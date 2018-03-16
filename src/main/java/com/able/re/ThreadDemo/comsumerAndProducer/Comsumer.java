package com.able.re.ThreadDemo.comsumerAndProducer;

import com.able.re.Demo.SetDemo;
import com.utils.RedisKey;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class Comsumer implements Runnable {

    private Storage storage;
    @Autowired
    private JedisTemplate jedisTemplate;
    private static boolean flag = true;

    public Comsumer(Storage storage) {
        this.storage = storage;
        //this.jedis = jedis;
    }

    @Override
    public void run() {
        try{
            Jedis jedis = new Jedis("127.0.0.1",6379);
            while (true){
                UserVideoStatistics userVideoStatistics = storage.pop();
                System.out.println("消费了对象。。。"+userVideoStatistics.toString());
                Long userId = userVideoStatistics.getUserId();
                Integer chapterId = userVideoStatistics.getChapterId();
                Integer lessonId = userVideoStatistics.getLessonId();
                Integer lessonVideoId = userVideoStatistics.getLessonVideoId();
                String time = userVideoStatistics.getTime();
                System.out.println("覆盖度----------"+time);
                String userVideoStatisticsKey = RedisKey.getUserVideoStatisticsKey(userId, chapterId, lessonId, lessonVideoId);
                System.out.println("userVideoStatisticsKey----------"+userVideoStatisticsKey);
                jedis.set(userVideoStatisticsKey, SetDemo.timeCover2Simple(time));

            }
        }catch(NullPointerException e1){
            System.out.println(Thread.currentThread().getName()+"消费完成！");
            e1.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
