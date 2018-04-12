package com.able.re.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProformanceHandler implements InvocationHandler {

    private Object target;

    public ProformanceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("jdk代理前置---------");
        Object obj = method.invoke(target, args);
        System.out.println("jdk代理后置---------");
        return obj;
    }
}
