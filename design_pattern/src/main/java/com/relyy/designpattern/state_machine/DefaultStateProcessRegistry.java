package com.relyy.designpattern.state_machine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 状态机引擎初始化
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public class DefaultStateProcessRegistry implements BeanPostProcessor {

	private static Map<String,Map<String, Map<String, List<AbstractStateProcessor>>>>
				stateProcessMap = new ConcurrentHashMap<>();

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AbstractStateProcessor && bean.getClass().isAnnotationPresent(OrderProcessor.class)){
			OrderProcessor annotation = bean.getClass().getAnnotation(OrderProcessor.class);
			String[] states = annotation.state();
			String event = annotation.event();
			String[] bizTypes = annotation.bizType().length == 0 ? new String[]{"#"} : annotation.bizType();
			String[] sceneIds = annotation.sceneId().length == 0 ? new String[]{"#"} : annotation.sceneId();
			initProcessMap(states,event,bizTypes,sceneIds,stateProcessMap,(AbstractStateProcessor)bean);
		}
		return null;
	}

	private <E extends StateProcessor> void initProcessMap(String[] states, String event, String[] bizTypes, String[] sceneIds,
	                                                       Map<String, Map<String, Map<String, List<E>>>> stateProcessMap,
	                                                       E processor) {
		for (String bizType : bizTypes) {
			for (String sceneId : sceneIds) {
				Arrays.asList(states).parallelStream().forEach(state -> {
					registerStateHandlers(state,event,bizType,sceneId,stateProcessMap,processor);
				});
			}
		}

	}

	private <E extends StateProcessor> void registerStateHandlers(String state, String event, String bizType, String sceneId,
	                                                              Map<String, Map<String, Map<String, List<E>>>> stateProcessMap,
	                                                              E processor) {

		if(!stateProcessMap.containsKey(state)){
			stateProcessMap.put(state,new ConcurrentHashMap<>());
		}
		Map<String, Map<String, List<E>>> stateTransformEventMap = stateProcessMap.get(state);

		if (!stateTransformEventMap.containsKey(event)){
			stateTransformEventMap.put(event,new ConcurrentHashMap<>());
		}
		Map<String, List<E>> processorMap = stateTransformEventMap.get(event);
		String bizTypeAndSceneId = bizType + "@" + sceneId;
		if (!processorMap.containsKey(bizTypeAndSceneId)){
			processorMap.put(bizTypeAndSceneId,new CopyOnWriteArrayList<>());
		}
		processorMap.get(bizTypeAndSceneId).add(processor);
	}

	public List<AbstractStateProcessor> acquireStateProcessor(String state,String event,String bizType,String sceneId){
		if(stateProcessMap.containsKey(state)){
			Map<String, Map<String, List<AbstractStateProcessor>>> stateTransformEventMap = stateProcessMap.get(state);
			if (stateTransformEventMap.containsKey(event)){
				Map<String, List<AbstractStateProcessor>> processorMap = stateTransformEventMap.get(event);
				String bizTypeAndSceneId = bizType + "@" + sceneId;
				if (processorMap.containsKey(bizTypeAndSceneId)){
					return processorMap.get(bizTypeAndSceneId);
				}
			}
		}
		return Collections.emptyList();
	}
}
