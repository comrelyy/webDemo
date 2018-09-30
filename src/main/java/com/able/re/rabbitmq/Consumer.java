package com.able.re.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/28
 */
public class Consumer {

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
        String queueName = "MY_HELLO_RABBITMQ";
        channel.queueDeclare(queueName,false,false,true,null);
//        while (true) {
//            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
//                @Override
//                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    String s = new String(body, "UTF-8");
//                    System.out.println("消费消息：" + s);
//                }
//            };
//            channel.basicConsume(queueName, true, defaultConsumer);
//        }
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String routingKey = envelope.getRoutingKey();
                String exchange = envelope.getExchange();
                long deliveryTag = envelope.getDeliveryTag();
                channel.basicAck(deliveryTag,false);//手动确认消费消息
                //重新入队列，false:直接丢弃，告诉队列可以直接删除掉，true:可被重新消费
                //channel.basicReject(deliveryTag,false);
                //重新投递，将所有没有被消费者处理的消息放入队列
                //channel.basicRecover();
                //重新投递，没有被消费者处理的消息重新放入队列，可以指定是否还可以被当前消费者消费（待验证）
                //channel.basicRecover(true);
            }

            /**
             * channels 和 connections 关闭时调用
             * @param consumerTag
             * @param sig
             */
            @Override
            public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
                super.handleShutdownSignal(consumerTag, sig);
            }
        };
        String s = channel.basicConsume(queueName, true, consumer);

        channel.close();
        connection.close();
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        channel.basicConsume(queueName, true, consumer);
//        while (true){
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String s = new String(delivery.getBody());
//            System.out.println("消费消息："+s);
//        }
    }
}
