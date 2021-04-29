package com.relyy.designpattern.state_machine;

/**
 * @Description 状态机处理接口
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface StateProcessor<T,C> {

	/**
	 * 执行状态迁移的入口
	 * @param stateContext
	 */
	ServiceResult<T> action(StateContext<C> stateContext) throws Exception;
}
