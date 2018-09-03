package com.able.re.redis;

import redis.clients.jedis.Jedis;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class RedisInstance {
    private static String host = "127.0.0.1";
    private static int port = 6379;
    private static Jedis jedis = new Jedis(host,port);

    public static Jedis getJedis(){
        if (jedis == null){
            jedis = new Jedis(host,port);
        }

        return jedis;
    }

}
