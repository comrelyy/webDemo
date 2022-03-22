package com.relyy.spring.framework.resourceDemo.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-13
 */
public class ResourceDemo {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("/spring/spring-mvc.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
//        ITestService testService = (ITestService)factory.getBean("testService");
//        testService.printMsg();

    }
}
