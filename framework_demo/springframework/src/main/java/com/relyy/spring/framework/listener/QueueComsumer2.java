package com.relyy.spring.framework.listener;//package com.relyy.listener;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * $DISCRIPTION
// *
// * @author cairuirui
// * @create 2018/11/21
// */
//@Component
//public class QueueComsumer2 implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private JedisTemplate jedisTemplate;
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        if(event.getApplicationContext().getParent() == null) {
//            System.out.println("监听启动");
//
//           //this.jedisTemplate = new JedisTemplate(new JedisPool("127.0.0.1",6379));
//            process() ;	// 启动处理逻辑
//        }
//    }
//
//    private void process() {
//        new Thread(){
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//
//                        List<String> myqueuekey = jedisTemplate.brpop(0, "myqueuekey");
//                        if (CollectionUtils.isNotEmpty(myqueuekey)) {
//                            System.out.println("consumer2消费---------"+myqueuekey.get(1));
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }.start();
//
//    }
//}
