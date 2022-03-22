package com.relyy.spring.framework.resourceDemo.bean;

import com.relyy.spring.framework.resourceDemo.annotation.ConfigurationDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        //System.out.println(applicationContext.getBean("sun"));

        //System.out.println(applicationContext.getBean("outter"));

//        System.out.println(applicationContext.getBean("collectionInject"));
        //使用lookup-method和replace-method,会触发spring使用cglib创建对象而不使用jvm的反射
        // 当一个单例bean依赖一个原型bean，那么这个依赖的bean的实例也会被缓存，就违背原型的设计初衷
        // 使用lookup-method可以解决该问题
//        Car car1 = applicationContext.getBean("car", Car.class);
//        Car car2 = applicationContext.getBean("car", Car.class);
//        System.out.println("singleton car:car1==car2的结果是:"+(car1==car2));
//
//        Taxi taxi1 = car1.getTaxi();
//        Taxi taxi2 = car1.getTaxi();
//        System.out.println("singleton car,prototype Taxi,no look-method aboult taxi1==taxi2:"+(taxi1==taxi2));
//        Taxi taxi4 = car1.createTaxi();
//        Taxi taxi3 = car2.createTaxi();
//        System.out.println("singleton car,prototype Taxi,look-method aboult taxi3==taxi4:"+(taxi3==taxi4));

        //OriginalDog originalBean = applicationContext.getBean("originalBean", OriginalDog.class);
        //originalBean.sayHello("输出结果被替换。。。。");

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
    }
}
