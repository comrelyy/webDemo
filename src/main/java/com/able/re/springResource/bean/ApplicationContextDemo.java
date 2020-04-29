package com.able.re.springResource.bean;

import com.able.re.springResource.bean.factorybean.Student;
import com.relyy.service.ITestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-30
 */
public class ApplicationContextDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/spring-bean.xml");

        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student.toString());


    }
}
