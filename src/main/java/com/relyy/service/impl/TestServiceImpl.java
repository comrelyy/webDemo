package com.relyy.service.impl;

import com.relyy.VO.UserVO;
import com.relyy.dao.TestMapper;
import com.relyy.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author cairuirui
 * @date 2017-07-17
 */
@Service("testService")
public class TestServiceImpl implements ITestService{

    TestServiceImpl(){}
    @Resource
    private TestMapper testMapper;


    @Override
    public UserVO getUserById(int id) {
        UserVO userVO = testMapper.selectById(id);

        return userVO;
    }

    @Override
    public void printMsg() {
        System.out.println("我被创建出来了。。。。。。。。。。");
    }
}
