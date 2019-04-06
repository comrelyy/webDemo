package com.able.re.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-05
 */
public class RedisDemo {

    public static void main(String[] args) {
//        //主机
//        String host = "127.0.0.1";
//
//        //端口
//        int port = 6379;

        Jedis jedis = RedisInstance.getJedis();
        //String s = "se:9995:419627:170750879";
        //List<String> myqueuekey = jedis.brpop(0, "myqueuekey");
        //.out.println(myqueuekey.get(1));
        Integer score = null;
        try{
            jedis.zadd("mytest",score,"1");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }

//        jedis.set(s.getBytes(),"homework".getBytes());
//        if (jedis.exists(s)){
//            System.out.println(true);
//        }
//        for (int i = 1;i < 52; i ++) {
//            Integer userId = 1;
//
//            String s = "6629:34693:" + userId;
//            jedis.lpush("onlineexam:submitExamFailed",s);
//        }

        //Pipeline pipeline = jedis.pipelined();


    }
}
