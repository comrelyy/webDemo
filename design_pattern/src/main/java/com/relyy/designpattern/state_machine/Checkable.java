package com.relyy.designpattern.state_machine;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Description 状态机校验器
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface Checkable {

	/**
	 * 参数校验
	 * @return
	 */
	default List<CheckProcessor> getParamChecker(){
		return Collections.EMPTY_LIST;
	}

	/**
	 * 需同步执行的校验器
	 * @return
	 */
	default List<CheckProcessor> getSyncChecker(){
		return Collections.EMPTY_LIST;
	}

	/**
	 * 可异步执行的校验器
	 * @return
	 */
	default List<CheckProcessor> getAsyncChecker(){
		return Collections.EMPTY_LIST;
	}

}
