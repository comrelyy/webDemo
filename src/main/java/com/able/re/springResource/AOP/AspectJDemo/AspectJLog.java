package com.able.re.springResource.AOP.AspectJDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class AspectJLog {

    @Pointcut("execution(public int com.able.re.springResource.AOP.AspectJDemo.TargetObject.div(int,int))")
    public void pointCut(){}


    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();//目标方法的入参的参数值
        //joinPoint.getSignature() 目标方法的方法签名
        System.out.println("除法"+joinPoint.getSignature().getName()+"运行开始------参数{"+Arrays.asList(args) +"}-");
    }

    @After("pointCut()")
    public void logend(JoinPoint joinPoint){
        System.out.println("除法"+joinPoint.getSignature().getName()+"运行结束----------");
    }

//    @Around("pointCut()")
//    public void logRound(JoinPoint joinPoint){
//        System.out.println("除法"+joinPoint.getSignature().getName()+"环绕运行----------");
//    }

    @AfterReturning(value ="pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        //JoinPoint参数必须在其他参数前面，否则会报错
        //result 目标方法返回值
        System.out.println("除法"+joinPoint.getSignature().getName()+"正常返回--------{"+result+"}");
    }

    @AfterThrowing(value="pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        //exception 目标方法执行发生的异常
        System.out.println("除法"+joinPoint.getSignature().getName()+"运行异常------{"+ exception.getMessage()+"}-");
    }
}
