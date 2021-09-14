package com.relyy.spring.framework.resourceDemo.bean.factorybean;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/4
 */
public class StudentFactory {

	public Student newInstance(String name,Integer age,String className){
		return new Student(name,age,className);
	}
}
