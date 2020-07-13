package com.able.re.designMode.bridgepatten;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/22
 */
public class WorkBinAgvJobStateChange extends AgvJobStateChange {
	public WorkBinAgvJobStateChange(Job job) {
		super(job);
	}

	@Override
	boolean handle(String event) {
		return job.handleJobEvent(event);
	}
}
