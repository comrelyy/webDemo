package com.able.re.proxy.jdkdynamicproxy;

import com.able.re.proxy.jdkdynamicproxy.impl.TargetObjImpl;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        ITargetObj target = new TargetObjImpl();
        ProformanceHandler handler = new ProformanceHandler(target);
        ITargetObj proxy = (ITargetObj) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        proxy.onlyTodo();
    }
}
