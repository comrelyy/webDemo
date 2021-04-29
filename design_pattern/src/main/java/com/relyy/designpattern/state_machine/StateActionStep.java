package com.relyy.designpattern.state_machine;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface StateActionStep<T,C> {

	/**
	 * 准备数据
	 */
	default void prepare(StateContext<C> stateContext){

	}

	Checkable getCheckable(StateContext<C> stateContext);
	/**
	 * 校验
	 * @param stateContext
	 * @return
	 */
	ServiceResult<T> check(StateContext<C> stateContext);

	/**
	 * 获取下一个状态
	 * @param stateContext
	 * @return
	 */
	String getNextState(StateContext<C> stateContext);

	/**
	 * 执行状态变更的逻辑
	 * @param nextState
	 * @param stateContext
	 * @return
	 * @throws Exception
	 */
	ServiceResult<T> action(String nextState,StateContext<C> stateContext) throws Exception;

	/**
	 * 状态数据持久化
	 * @param nextState
	 * @param stateContext
	 * @return
	 * @throws Exception
	 */
	ServiceResult<T> save(String nextState,StateContext<C> stateContext) throws Exception;

	/**
	 * 状态迁移成功，持久化后执行的后续处理
	 * @param stateContext
	 */
	void after(StateContext<C> stateContext);
}
