package com.relyy.designpattern.state_machine;

/**
 * @Description 状态机校验器
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface CheckProcessor<T,C> {
	ServiceResult<T> check(StateContext<C> context);

	/**
	 * 多个checkProcessor时的执行顺序
	 */
	default int order(){
		return 0;
	}

	/**
	 * 是否需要释放
	 * @return
	 */
	boolean needRelease();

	/**
	 * 业务执行完成后的释放方法,
	 * 比如有些业务会在checker中加一些状态操作，等业务执行完成后根据结果选择处理这些状态操作,
	 * 最典型的就是checker中加一把锁，release根据结果释放锁 .
	 * @param stateContext
	 * @param serviceResult
	 */
	void release(StateContext<C> stateContext,ServiceResult<T> serviceResult);
}
