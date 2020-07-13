package com.able.re.springResource.annotation;

import com.able.re.springResource.bean.factorybean.Student;
import com.able.re.springResource.bean.factorybean.StudentFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

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
