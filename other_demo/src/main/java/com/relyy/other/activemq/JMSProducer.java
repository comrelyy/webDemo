package com.relyy.other.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ实现JMS消息生产者
 *
 * @author cairuirui
 * @date 2017-10-30
 */
public class JMSProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final int  SENDNUM = 10;


    public static void main(String[] args) {

        ConnectionFactory connectionFactory;

        Connection connection = null;

        Session session;

        Destination destination;

        MessageProducer producer;

        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME,JMSProducer.PASSWORD,JMSProducer.BROKERURL);

        try{
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("Hello MQ");

            producer = session.createProducer(destination);

            sendMessage(session,producer);

            session.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {

            if (connection != null) {
                try{
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void sendMessage(Session session, MessageProducer producer) throws Exception{
        for (int i = 0; i < JMSProducer.SENDNUM; i++){

            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" +i);

            System.out.println("发送消息：ActiveMQ 发送消息" + i);

            producer.send(message);
        }
    }

}
