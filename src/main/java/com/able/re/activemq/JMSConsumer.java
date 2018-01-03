package com.able.re.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ实现JMS消费者
 *
 * @author cairuirui
 * @date 2017-10-30
 */
public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;

        Connection connection  = null;

        Session session;

        Destination destination;

        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME,JMSConsumer.PASSWORD,JMSConsumer.BROKERURL);

        try{

            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("Hello MQ");

            consumer = session.createConsumer(destination);

            while (true){
                TextMessage message =(TextMessage) consumer.receive(100000);

                if (message != null) {
                    System.out.println("ActiveMQ 收到消息："+message.getText());
                }else {
                    break;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
