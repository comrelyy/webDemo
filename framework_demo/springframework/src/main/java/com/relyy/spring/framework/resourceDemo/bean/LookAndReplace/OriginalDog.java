package com.relyy.spring.framework.resourceDemo.bean.LookAndReplace;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/8
 */
public class OriginalDog {
	public void sayHello(){
		System.out.println("Hello,I am a black dog...");
	}

	public void sayHello(String name){
		System.out.println("Hello,I am a black dog,my name is "+name);
	}
}
