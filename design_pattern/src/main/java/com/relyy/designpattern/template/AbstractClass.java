package com.relyy.designpattern.template;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/7/14
 */
public abstract class AbstractClass {

	void methodA(){
		//doSomething
		methodB();
		// continue do something
	}

	abstract void methodB();
}
