package com.relyy;

import com.relyy.VO.User;
import com.relyy.service.IUserService;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.cache.interceptor.DefaultKeyGenerator;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/30
 */
public class ShardingJdbcTest extends TestBaseService {

    @Resource
    private IUserService userService;
    @Resource
    private JedisTemplate jedisTemplate;

    private static final String userGeneratorKey = "t:user:primary:key";

    @Test
    public void setUserGeneratorKey() throws Exception {
        jedisTemplate.set(userGeneratorKey,"1");
    }

    @Test
    public void getUserGeneratorKey() throws Exception {
        System.out.println("redis主键"+jedisTemplate.get(userGeneratorKey));
    }
    @Test
    public void InsertUserTest() throws Exception {
        User user = new User();
        /*
        分库分表使用redis记录分布式id，还可以使用数据库，或者其他方式：如uuid，
        这里主要是为了使用sharding-jdbc,实现分库分表的是测试
        */
        user.setId(jedisTemplate.incr(userGeneratorKey).intValue());
        user.setAge(28);
        user.setName("five");
        user.setUserId(10);
        boolean insert = userService.insert(user);
    }

    @Test
    public void findAllUserTest() throws Exception {
        List<User> all = userService.findAll();
        if (CollectionUtils.isNotEmpty(all)) {
            for (User user : all) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void findByUserIdsTest() throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(6);
        ids.add(3);
        ids.add(5);
        List<User> byUserIds = userService.findByUserIds(ids);
        if (CollectionUtils.isNotEmpty(byUserIds)) {
            for (User user : byUserIds) {
                System.out.println(user);
            }
        }
    }
}
