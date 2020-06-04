package com.able.re.springResource.bean;

import com.able.re.springResource.bean.factorybean.Student;
import com.relyy.service.ITestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-30
 */
public class ApplicationContextDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-bean.xml");

//        Student student3 = (Student)applicationContext.getBean("student3");
//        System.out.println(student3);
//        Student student4 = (Student)applicationContext.getBean("student4");
//        System.out.println(student4);
//        Student student5 = (Student)applicationContext.getBean("student5");
//        System.out.println(student5);
        //System.out.println(student.toString());

        System.out.println(applicationContext.getBean("sun"));
    }
}
