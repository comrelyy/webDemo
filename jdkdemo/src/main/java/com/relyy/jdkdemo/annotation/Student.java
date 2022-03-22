package com.relyy.jdkdemo.annotation;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/4/28
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Accessors(chain = true)
@Component("student")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
