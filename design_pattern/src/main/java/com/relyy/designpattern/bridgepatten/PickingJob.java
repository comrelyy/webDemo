package com.relyy.designpattern.bridgepatten;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/22
 */
public class PickingJob implements Job {

	@Override
	public boolean handleJobEvent(String event) {

		System.out.println("picking job deal with "+event);
		return true;
	}
}
