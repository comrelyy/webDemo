package com.able.re.springResource.AOP.AspectJDemo;

import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJLog {

    @Pointcut("execution(public int com.able.re.springResource.AOP.AspectJDemo.TargetObject.div(int,int))")
    public void pointCut(){}


    @Before("pointCut()")
    public void logStart(){
        System.out.println("除法运行开始----------");
    }

    @After("pointCut()")
    public void logend(){
        System.out.println("除法运行结束----------");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("除法正常返回----------");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("除法运行异常---------");
    }
}
