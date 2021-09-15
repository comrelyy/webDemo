package com.relyy.other.redis;

import redis.clients.jedis.Jedis;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class RedisInstance {
    private static String host = "192.168.9.170";
    private static int port = 19000;
    private static Jedis jedis = new Jedis(host,port);

    public static Jedis getJedis(){
        if (jedis == null){
            jedis = new Jedis(host,port);
        }

        return jedis;
    }

}
