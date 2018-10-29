package com.kevin.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class DefaultResponseQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("接收到发送到defaultResponseQueue的消息:" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
