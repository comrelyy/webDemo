package com.relyy.designpattern.state_machine;

import javax.annotation.Resource;

/**
 * @Description 状态机处理器模板类
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public abstract class AbstractStateProcessor<T,C> implements StateProcessor<T,C>,StateActionStep<T,C> {

	@Resource
	private CheckerExecutor checkerExecutor;

	@Override
	public ServiceResult<T> action(StateContext<C> stateContext) throws Exception {
		ServiceResult<T> result = null;
		Checkable checkable = this.getCheckable(stateContext);
		try{
			//参数校验器
			result = checkerExecutor.serialCheck(checkable.getParamChecker(), stateContext);
			if (!result.isSuccess()){
				return result;
			}
			//数据准备
			this.prepare(stateContext);
			result = checkerExecutor.serialCheck(checkable.getSyncChecker(),stateContext);
			if (!result.isSuccess()){
				return result;
			}

			result = checkerExecutor.parallerCheck(checkable.getAsyncChecker(),stateContext);
			if (!result.isSuccess()){
				return result;
			}
			//获取下一个状态
			String nextState = this.getNextState(stateContext);

			//业务逻辑
			result = this.action(nextState, stateContext);
			if (!result.isSuccess()){
				return result;
			}
			//持久化
			result = this.save(nextState, stateContext);
			if (!result.isSuccess()){
				return result;
			}
			//后处理
			this.after(stateContext);
			return result;
		} catch(Exception e){
		    throw e;
		}
	}
}
