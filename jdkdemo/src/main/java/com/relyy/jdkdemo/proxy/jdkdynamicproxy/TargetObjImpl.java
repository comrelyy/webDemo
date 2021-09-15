package com.relyy.jdkdemo.proxy.jdkdynamicproxy;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/8/3
 */
public class TargetObjImpl implements ITargetObj {
	@Override
	public void onlyTodo() {
		System.out.println("hello my code life");
	}
}
