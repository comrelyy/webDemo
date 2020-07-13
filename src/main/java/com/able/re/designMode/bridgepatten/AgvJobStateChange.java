package com.able.re.designMode.bridgepatten;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/22
 */
public abstract class AgvJobStateChange {

	protected Job job;

	public AgvJobStateChange(Job job){
		this.job = job;
	}

	abstract boolean handle(String event);
}
