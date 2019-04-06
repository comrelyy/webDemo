package com.able.re.Demo;

import com.relyy.VO.UserVO;

import java.util.Date;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/3/1
 */
public class AnotherDemo {

    public static void main(String[] args) {
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setName("before");
        userVO.setCreateTime(new Date());
        System.out.println(userVO);
        doAnother(userVO);
        System.out.println(userVO);
    }

    private static void doAnother(UserVO userVO) {
        userVO.setName("after");
        userVO.setCreateTime(new Date());
    }
}
