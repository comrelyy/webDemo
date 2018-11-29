package com.relyy;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 *
 * @author cairuirui
 * @create 2018/10/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mvc.xml")
public class TestBaseService {

    private long time;

    @Before
    public void start(){
        this.time = System.currentTimeMillis();
    }

    @After
    public void end(){
        System.out.println(String.format("方法执行了 %d ms",System.currentTimeMillis() - time));
    }
}
