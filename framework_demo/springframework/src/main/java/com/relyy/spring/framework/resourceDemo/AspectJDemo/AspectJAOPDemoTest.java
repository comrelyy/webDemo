package com.relyy.spring.framework.resourceDemo.AspectJDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJAOPDemoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectLogConfiguration.class);
        TargetObject targetObject =  applicationContext.getBean(TargetObject.class);
        targetObject.div(6,1);
    }
}
