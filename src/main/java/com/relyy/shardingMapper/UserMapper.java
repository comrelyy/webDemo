package com.relyy.shardingMapper;

import com.relyy.VO.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
@Component("userMapper")
public interface UserMapper {

    Integer insert(User user);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);
}
