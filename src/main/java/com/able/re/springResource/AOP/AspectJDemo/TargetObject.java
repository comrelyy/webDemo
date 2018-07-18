package com.able.re.springResource.AOP.AspectJDemo;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    public int div(int a, int b){
        System.out.println("执行了减法");
        return b/a;
    }
}
