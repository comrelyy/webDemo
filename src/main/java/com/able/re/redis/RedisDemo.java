package com.able.re.redis;

import redis.clients.jedis.Jedis;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-05
 */
public class RedisDemo {

    public static void main(String[] args) {
        //主机
        String host = "127.0.0.1";

        //端口
        int port = 6379;

        Jedis jedis = new Jedis(host,port);

        System.out.println(jedis.get("mystring"));
    }
}
