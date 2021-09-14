package com.relyy.spring.framework.resourceDemo.configuration;

import com.relyy.spring.framework.resourceDemo.factorybean.FactoryBeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-18
 */

public class MainFactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        System.out.println(applicationContext.getBean("appleFactoryBean"));
        System.out.println(applicationContext.getBean("&appleFactoryBean"));
    }

}
