package com.kevin.mq.producer.queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MyMessageProducer4 {

    private JmsTemplate jmsTemplate;

    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, String msg) {
            jmsTemplate.convertAndSend(destination, msg);
            System.out.println("向队列" + destination.toString() + "发送消息--------" + msg);
    }

    /**
     * 向默认队列发送消息
     */
    public void sendMessage(String msg) {
        Destination destination = jmsTemplate.getDefaultDestination();
        jmsTemplate.convertAndSend(msg);
        System.out.println("向队列" + destination.toString() + "发送消息--------" + msg);
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
