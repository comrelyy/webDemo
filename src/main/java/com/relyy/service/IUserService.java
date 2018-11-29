package com.relyy.service;

import com.relyy.VO.User;

import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
public interface IUserService {

    public boolean insert(User u);

    public List<User> findAll();

    public List<User> findByUserIds(List<Integer> ids);

    public void transactionTestSucess();

    public void transactionTestFailure() throws IllegalAccessException;

}
