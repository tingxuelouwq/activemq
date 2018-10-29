package com.kevin.mq.consumer.topic;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

public class MySessionAwareMessageListener implements SessionAwareMessageListener {

    private Destination destination;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage msg = (TextMessage) message;
        System.out.println("收到一条消息:" + msg.getText());

        MessageProducer producer = session.createProducer(destination);
        Message msg2 = session.createTextMessage("通过SessionAwareMessageListener发送回执消息");
        producer.send(msg2);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
