package com.relyy.service.impl;

import com.relyy.VO.UserVO;
import com.relyy.dao.TestMapper;
import com.relyy.service.ITestService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author cairuirui
 * @date 2017-07-17
 */
@Service
public class TestServiceImpl implements ITestService{

    @Resource
    private TestMapper testMapper;


    @Override
    public UserVO getUserById(int id) {
        UserVO userVO = testMapper.selectById(id);

        return userVO;
    }
}
