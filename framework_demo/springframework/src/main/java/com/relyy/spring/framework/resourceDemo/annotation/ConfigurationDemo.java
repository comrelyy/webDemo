package com.relyy.spring.framework.resourceDemo.annotation;

import com.relyy.spring.framework.resourceDemo.bean.factorybean.Student;
import com.relyy.spring.framework.resourceDemo.bean.factorybean.StudentFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.*;


/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/11
 */
@Configuration
//@Import(value = StudentFactoryBean.class)
@ComponentScan(basePackageClasses = {StudentFactoryBean.class})
//@PropertySource()
//@MapperScan
//@EnableRabbit
@EnableAspectJAutoProxy
public class ConfigurationDemo {

//	@Bean
//	public Student getStudent(){
//		return new Student();
//	}
}
