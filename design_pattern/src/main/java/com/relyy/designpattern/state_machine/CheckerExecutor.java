package com.relyy.designpattern.state_machine;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description 校验执行器
 * @Created by cairuirui
 * @Date 2021/4/29
 */
@Component
public class CheckerExecutor {

	private static final ExecutorService executor = Executors.newCachedThreadPool();

	public <T,C> ServiceResult<T> parallerCheck(List<CheckProcessor<T,C>> checkProcessorList,StateContext<C> stateContext){
		if (null != checkProcessorList && !checkProcessorList.isEmpty()){
			if (checkProcessorList.size() == 1){
				return checkProcessorList.get(0).check(stateContext);
			}
		}

		List<Future<ServiceResult>> resultList =
				Collections.synchronizedList(new ArrayList<>(checkProcessorList.size()));

		checkProcessorList.sort(Comparator.comparingInt(CheckProcessor::order));

		for (CheckProcessor<T, C> checkProcessor : checkProcessorList) {
			Future<ServiceResult> submit = executor.submit(() -> checkProcessor.check(stateContext));
			resultList.add(submit);
		}
		for (Future<ServiceResult> future : resultList) {
			try{
				ServiceResult serviceResult = future.get();
				if (!serviceResult.isSuccess()){
					return serviceResult;
				}
			} catch(Exception e){
			    throw new RuntimeException(e);
			}
		}
		return new ServiceResult<>();
	}

	public <T,C> ServiceResult<T> serialCheck(List<CheckProcessor<T,C>> checkProcessorList,StateContext<C> stateContext){

		checkProcessorList.sort(Comparator.comparingInt(CheckProcessor::order));

		for (CheckProcessor<T, C> checkProcessor : checkProcessorList) {
			ServiceResult serviceResult = checkProcessor.check(stateContext);
			if (!serviceResult.isSuccess()){
				return serviceResult;
			}
		}
		return new ServiceResult<>(true);
	}

	public <T,C> void releaseCheck(Checkable checkable,StateContext<C> stateContext,ServiceResult<T> serviceResult){
		List<CheckProcessor> checkList = new ArrayList<>();
		checkList.addAll(checkable.getParamChecker());
		checkList.addAll(checkable.getSyncChecker());
		checkList.addAll(checkable.getAsyncChecker());
		checkList.removeIf(CheckProcessor::needRelease);
		if (CollectionUtils.isNotEmpty(checkList)){
			if (checkList.size() == 1){
				checkList.get(0).release(stateContext,serviceResult);
				return ;
			}

			CountDownLatch countDownLatch = new CountDownLatch(checkList.size());
			for (CheckProcessor processor : checkList) {
				executor.execute(() -> {
					try{
						processor.release(stateContext,serviceResult);
					}finally{
						countDownLatch.countDown();
					}
				});
			}

			try{
				countDownLatch.await();
			} catch(Exception e){
			    throw new RuntimeException(e);
			}
		}
	}
}
