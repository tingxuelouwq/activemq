package com.kevin.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

// 消息监听器
public class MyMessageListener7 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
//            if (1 == 1) {
//                throw new RuntimeException("接收消息时抛出异常");
//            }
            System.out.println("接收到消息:" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
