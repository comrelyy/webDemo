package com.able.re.ThreadDemo.comsumerAndProducer;

import com.able.re.redis.RedisInstance;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class Demo {

    public static void main(String[] args) {
        Storage storage = new Storage();
        //Jedis jedis = RedisInstance.getJedis();
        long l = System.currentTimeMillis();
        update(storage);
        long l1 = System.currentTimeMillis();
        System.out.println("耗时【" + (l1 - l) + "】");
    }

    private static void update(Storage storage) {


        ExecutorService service = Executors.newCachedThreadPool();

        Producer p = new Producer(storage);
        service.submit(p);
        service.submit(new Comsumer(storage));
//        for (int i = 0; i < 2; i++) {
//            System.out.println("消费线程"+i+",正在消费中。。。。。。。。。。。");
//            service.submit(new Comsumer(storage));
//        }
    }
}
