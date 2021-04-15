package com.relyy.jdkdemo.proxy.jdkdynamicproxy;

import com.relyy.jdkdemo.proxy.jdkdynamicproxy.impl.TargetObjImpl;

public class Test {

    public static void main(String[] args) {
        ITargetObj target = new TargetObjImpl();
        ProformanceHandler handler = new ProformanceHandler(target);
//        ITargetObj proxy = (ITargetObj) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                handler);
        ITargetObj proxy = (ITargetObj)handler.getProxy();

        proxy.onlyTodo();
    }
}
