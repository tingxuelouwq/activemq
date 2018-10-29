package com.kevin.mq.producer.queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;

public class MyMessageProducer3{

    private JmsTemplate jmsTemplate;

    /**
     * 不使用MessageConverter发送消息
     */
    public void sendMessage(Destination destination, Serializable obj) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(obj);
                return objectMessage;
            }
        });
    }

    /**
     * 使用MessageConverter发送消息
     */
    public void sendMessage2(Destination destination, Serializable obj) {
        jmsTemplate.convertAndSend(destination, obj);
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
