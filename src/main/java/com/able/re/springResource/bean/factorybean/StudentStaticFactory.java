package com.able.re.springResource.bean.factorybean;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/4
 */
public class StudentStaticFactory {

	public static Student newInstance(String name,Integer age,String className){
		return new Student(name,age,className);
	}
}
