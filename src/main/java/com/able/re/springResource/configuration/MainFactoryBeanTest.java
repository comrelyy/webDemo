package com.able.re.springResource.configuration;

import com.able.re.springResource.factorybean.FactoryBeanConfiguration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
