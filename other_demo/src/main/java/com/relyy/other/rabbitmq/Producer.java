package com.relyy.other.rabbitmq;

import com.rabbitmq.client.*;

import java.util.HashMap;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/28
 */
public class Producer {
    public static void main(String[] args) throws Exception{

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        //connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //connectionFactory.setVirtualHost("/");
        //connectionFactory.setUri("amqp://guest:guest@localhost:5672/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "MY_HELLO_RABBITMQ";
//        channel.queueDeclare(queueName,false,false,true,null);
//        for (int i = 0; i < 5; i++) {
//            String msg = "Hello rabbitmq "+i;
//            channel.basicPublish("", queueName, null, msg.getBytes());
//        }
        channel.exchangeDeclare(exchangeName,"direct",true);
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("生产者队列名："+queueName);
        channel.queueBind(queueName,exchangeName,"");


        String messageBody = "hello,rabbitmq";
        /**********只是一些方法介绍**************/
        //声明一个队列
        channel.queueDeclare(queueName,false,false,false,null);
        //声明一个交换机
        /**
        BuiltinExchangeType.DIRECT; ----
                绑定时会将queueName,exchangeName，routtingkey作为一条记录，
                消息发布时指定exchangeName和routingkey可以找到绑定的queueName,消息就会路由到绑定的queue中
        BuiltinExchangeType.FANOUT; Exchange将消息路由到所有与它绑定的Queue中,广播类型（扇形），会忽略routingkey,处理消息速度最快
        BuiltinExchangeType.TOPIC; Exchange将消息路由到bindingkey 与routingkey 模式匹配的Queue中，
                可以使用*和#来进行模糊匹配，routingkey必须是由点(.)隔开的一些列标识符
        BuiltinExchangeType.HEADERS;不依赖于bindingkey 与routingkey 的匹配来路由消息，而是根据消息中Headers属性进行匹配
         */
       // channel.exchangeDeclare(exchangeName,BuiltinExchangeType.DIRECT);
        //将队列，交换机，路由键绑定起来,这里的routingkey可以理解为bindingkey
        channel.queueBind(queueName,exchangeName,"routing.key");
        //
        //发布消息,如果不指定交换机名称，routingkey需要和队列名保持一致，标识轻量级消息队列
        channel.basicPublish(exchangeName,"routing.key",null,messageBody.getBytes());
        //检查指定的队列名是否存在，如果队列存在就返回队列的信息，如果不存在就抛出异常
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(queueName);
        int messageCount = declareOk.getMessageCount();//消息队列中处于准备状态的消息数量
        int consumerCount = declareOk.getConsumerCount();//消息队列中消费者数量
        //声明队列
        /**
         * 参数：
         * queue 队列名称
         * durable 是否持久化：rabbitmq服务器重启，消息是否会丢失，true：被保存到自动Mnesia数据库中；false:重启后数据丢失，默认false
         * exclusive 是否排外：1，连接关闭时，该队列是否会自动删除
         *          2，队列是否私有，为true时，当前队列加锁，一个队列只能有一个消费，其他channel不能访问，强制访问会报错；
         *                          false:多个消费者可以访问同一个队列
         * autoDelete 是否自动删除：当consumer=0时队列是否需要自动删除
         * arguments 队列属性设置：队列消息的生存周期
         */
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl",10000);//声明队列中消息过期时间
        arguments.put("x-expires",10000);//设置没有消费者访问该队列后多长时间队列会自动删除
        arguments.put("x-max-length",4);//指定队列长度，不指定则无限长
        arguments.put("x-max-length-bytes",10240);//指定队列消息的占用空间大小，当达到最大值，会删除之前的数据
        arguments.put("x-max-priority",5);//指定队列消息的优先级，优先级值越大，越被提前消费

        channel.queueDeclare(queueName,true,false,true,arguments);

        /**
         * 删除相关
         */
        channel.queueDelete(queueName);//明确删除指定队列
        channel.queueDelete(queueName,false,true);//删除在使用的但是队列中没有消息的队列
        channel.queueDelete(queueName,true,false);//删除不再使用的队列
        channel.queuePurge(queueName);//清空队列中的消息

        /**
         * 消息发布相关
         */

        channel.basicPublish(exchangeName,"",null,messageBody.getBytes());
        /**
         * 1、轮询分发（Round-robin）:不关注消费者处理消息的能力，将消息平均分配给每个消费者
         * 2、公平转发（Fair-dispatch）：根据消费者处理能力，消费者处理完成一条再分发下一条
         *    channel.basicQos(1)告诉消费者一次只能从队列中预先获取一条（prefetchCount）
         */

        /**
         * 设置消息持久化的方式
         */
        //1、
        AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties.Builder();
        properties.deliveryMode(2);//1 非持久化; 2 持久化
        channel.basicPublish(exchangeName,"",properties.build(),messageBody.getBytes());
        //2、
        channel.basicPublish(exchangeName,"", MessageProperties.PERSISTENT_TEXT_PLAIN,messageBody.getBytes());

        /**
         * 生产者确认：当生产者发布消息到RabbitMq中，RabbitMq服务器需要告诉生产者消息是否真实发送
         * 1 Confirm机制：channel.confirmSelect();channel.waitForConfirms();
         * 2 事务机制：channel.txSelect();channel.txRollback();
         * 但是事务机制非常消耗性能，最好使用Confirm机制
         */

        channel.close();
        connection.close();
    }


}
