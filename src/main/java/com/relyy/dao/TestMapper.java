package com.relyy.dao;


import com.relyy.VO.UserVO;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper {

    /**
     * @desc
     * @author: cairuirui
     * @date
     * @param id
     * @return
     */
    UserVO selectById(int id);
}
