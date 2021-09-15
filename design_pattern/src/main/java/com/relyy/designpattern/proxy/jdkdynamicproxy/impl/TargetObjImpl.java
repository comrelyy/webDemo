package com.relyy.designpattern.proxy.jdkdynamicproxy.impl;


import com.relyy.designpattern.proxy.jdkdynamicproxy.ITargetObj;

public class TargetObjImpl implements ITargetObj {

    @Override
    public void onlyTodo() {
        System.out.println("hello my code life");
    }
}
