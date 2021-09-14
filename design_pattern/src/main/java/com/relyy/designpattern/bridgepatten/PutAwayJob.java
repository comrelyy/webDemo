package com.relyy.designpattern.bridgepatten;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/22
 */
public class PutAwayJob implements Job {
	@Override
	public boolean handleJobEvent(String event) {
		System.out.println("putaway deal with event "+event);
		return true;
	}
}
