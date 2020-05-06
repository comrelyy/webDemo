//package com.able.re.ThreadDemo;
//
//import com.able.re.redis.RedisInstance;
//import org.apache.commons.collections.CollectionUtils;
//import redis.clients.jedis.Jedis;
//
//import java.util.List;
//
///**
// * $DISCRIPTION
// *
// * @author cairuirui
// * @create 2018/11/21
// */
//public class RedisQueueDemo {
//
//    public static void main(String[] args) {
//        final Jedis jedis = RedisInstance.getJedis();
//        new Thread(){
//            @Override
//            public void run() {
//                try{
//                    System.out.println("监听启动");
//                    while (true){
//                        List<String> myqueuekey = jedis.brpop(0, "myqueuekey");
//                        if (CollectionUtils.isNotEmpty(myqueuekey)) {
//                            System.out.println(myqueuekey.get(1));
//                        }
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                try{
//                    System.out.println("监听启动");
//                    while (true){
//                        List<String> myqueuekey = jedis.brpop(0, "myqueuekey");
//                        if (CollectionUtils.isNotEmpty(myqueuekey)) {
//                            System.out.println(myqueuekey.get(1));
//                        }
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//    }
//}
