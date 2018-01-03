package com.able.re.proxy;

import com.able.re.proxy.cgblib.MyCgblibDemo;
import com.able.re.proxy.cgblib.TargetDemo;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void cgblibTest(){
        MyCgblibDemo proxy = new MyCgblibDemo();

        TargetDemo proxyImpl = (TargetDemo) proxy.getProxy(TargetDemo.class);

        proxyImpl.sayWord();
    }
}
