package com.kevin.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

public class MyMessageListener6 {
    public void handleMessage(ObjectMessage message) throws JMSException {
        System.out.println("通过handleMessage()接收到消息:" + message.getObject());
    }

    public void receiveMessage(ObjectMessage message) throws JMSException {
        System.out.println("通过receiveMessage()接收到消息:" + message.getObject());
    }
}
