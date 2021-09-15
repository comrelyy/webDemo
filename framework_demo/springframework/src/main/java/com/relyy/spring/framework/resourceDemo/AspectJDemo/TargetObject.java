package com.relyy.spring.framework.resourceDemo.AspectJDemo;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    public int div(int a, int b){
        System.out.println("执行了除法");
        return b/a;
    }
}
