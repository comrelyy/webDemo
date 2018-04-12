package com.able.re.proxy.jdkdynamicproxy.impl;

import com.able.re.proxy.jdkdynamicproxy.ITargetObj;

public class TargetObjImpl implements ITargetObj {

    @Override
    public void onlyTodo() {
        System.out.println("hello my code life");
    }
}
