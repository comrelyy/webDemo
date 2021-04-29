package com.relyy.designpattern.state_machine;

/**
 * @Description 状态机执行引擎
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface OrderFsmEngine {

	/**
	 * 状态执行迁移事件
	 * @param orderStateEvent
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	<T> ServiceResult<T> sendEvent(OrderStateEvent orderStateEvent) throws Exception;



	<T> ServiceResult<T> sendEvent(OrderStateEvent orderStateEvent,FsmOrder fsmOrder) throws Exception;
}
