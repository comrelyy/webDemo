package com.relyy.rabbitMqReciever;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.relyy.VO.rabbitmqTestVo.AssignationMakeUpExamVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.util.HashMap;
import java.util.Map;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/30
 */
public class AssignationMakeUpExamForUserComsumer implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try{
            String messageBody = new String(message.getBody(),"UTF-8");
            if (StringUtils.isEmpty(messageBody)) {
                System.out.println("清除学生答题记录接收消息体为空");
                return;
            }
            System.out.println("清除学生答题记录接收消息体为空"+messageBody);
            HashMap<String,Integer> hashMap = (HashMap<String,Integer>)JSON.parseObject(messageBody, HashMap.class);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                Integer value = entry.getValue();
                String key = entry.getKey();
                System.out.println("key："+key+"-------"+"value:"+value);
            }
            System.out.println(hashMap.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
