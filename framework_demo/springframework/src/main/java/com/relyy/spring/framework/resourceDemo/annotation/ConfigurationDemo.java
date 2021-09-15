package com.relyy.spring.framework.resourceDemo.annotation;

import com.relyy.spring.framework.resourceDemo.bean.factorybean.Student;
import com.relyy.spring.framework.resourceDemo.bean.factorybean.StudentFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/11
 */
@Configuration
@Import(value = StudentFactoryBean.class)
//@PropertySource()
public class ConfigurationDemo {

	@Bean
	public Student getStudent(){
		return new Student();
	}
}
