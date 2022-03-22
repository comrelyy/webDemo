package com.relyy.spring.framework;

import com.relyy.spring.framework.resourceDemo.annotation.ConfigurationDemo;
import com.relyy.spring.framework.resourceDemo.bean.factorybean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Created by Reeve Cai
 * @Date 2022/2/8
 */
public class MainStarter {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
		Student bean = applicationContext.getBean(Student.class);

	}
}
