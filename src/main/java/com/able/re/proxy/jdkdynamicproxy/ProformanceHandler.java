package com.able.re.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProformanceHandler implements InvocationHandler {

    private Object target;

    public ProformanceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("jdk动态代理前置---------");
        Object obj = method.invoke(target, args);
        System.out.println("jdk动态代理后置---------");
        return obj;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),this);
    }

}
