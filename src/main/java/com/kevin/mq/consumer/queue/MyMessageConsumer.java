package com.kevin.mq.consumer.queue;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

public class MyMessageConsumer {

    private JmsTemplate jmsTemplate;

    /**
     * 从指定目队列接收消息
     */
    public void receive(Destination destination) {
        TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息-------" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从默认队列接收消息
     */
    public void receive() {
        Destination destination = jmsTemplate.getDefaultDestination();
        TextMessage msg = (TextMessage) jmsTemplate.receive();
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息-------" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
