package com.relyy.jdkdemo.Demo;

import java.net.URL;

/**
 * @Description
 * @Created by Reeve Cai
 * @Date 2022/3/11
 */
public class ClassLoadPathDemo {

	public static void main(String[] args) {
		//URL resource = ClassLoadPathDemo.class.getClassLoader().getResource("com\\relyy\\jdkdemo\\clone\\ChildVo.class");
		System.out.println(ClassLoadPathDemo.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
	}
}
