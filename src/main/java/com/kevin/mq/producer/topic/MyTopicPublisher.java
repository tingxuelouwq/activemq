package com.kevin.mq.producer.topic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MyTopicPublisher {

    private JmsTemplate jmsTemplate;

    /**
     * 向指定的topic发布消息
     */
    public void publish(Destination destination, String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println("向主题" + destination.toString() + "发布了消息-----" + msg);
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向默认的topic发布消息
     */
    public void publish(String msg) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Destination destination = jmsTemplate.getDefaultDestination();
                System.out.println("向主题" + destination.toString() + "发布了消息-----" + msg);
                return session.createTextMessage(msg);
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
