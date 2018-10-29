package com.kevin.mq.producer.queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MyMessageProducer2 {

    private JmsTemplate jmsTemplate;

    private Destination responseDestination;

    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息--------" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(msg);
//                设置该消息对应的回复目的地
                message.setJMSReplyTo(responseDestination);
                return message;
            }
        });
    }

    /**
     * 向默认队列发送消息
     */
    public void sendMessage(String msg) {
        Destination destination = jmsTemplate.getDefaultDestination();
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(msg);
//                设置该消息对应的回复目的地
                message.setJMSReplyTo(responseDestination);
                return message;
            }
        });
        System.out.println("向队列" + destination.toString() + "发送了消息--------" + msg);
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getResponseDestination() {
        return responseDestination;
    }

    public void setResponseDestination(Destination responseDestination) {
        this.responseDestination = responseDestination;
    }
}
