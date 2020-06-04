package com.able.re.springResource.bean.factorybean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/4/28
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Student {
	private String name;
	private int age;
	private String className;

	/**如果存在有参构造方法，把无参构造方法一并定义出来最佳*/
	public Student(){
		System.out.println("通过默认构造器注入----------");
	}

	public Student(String name, int age, String className) {
		this.name = name;
		this.age = age;
		this.className = className;
		System.out.println("通过三参数构造器注入----------");
	}
}
