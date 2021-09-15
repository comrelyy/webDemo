package com.relyy.designpattern.proxy.cgblib;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void cgblibTest(){
        MyCgblibDemo proxy = new MyCgblibDemo();

        TargetDemo proxyImpl = (TargetDemo) proxy.getProxy(TargetDemo.class);

        proxyImpl.sayWord();
    }
}
