package com.kevin.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

// 消息监听器
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("接收到消息:" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
