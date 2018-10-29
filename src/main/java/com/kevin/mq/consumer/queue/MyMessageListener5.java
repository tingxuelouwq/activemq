package com.kevin.mq.consumer.queue;

import com.kevin.domain.Email;

public class MyMessageListener5 {

    public void handleMessage(Email email) {
        System.out.println("通过handleMessage()接收到消息:" + email);
    }

    public void receiveMessage(Email email) {
        System.out.println("通过receiveMessage()接收到消息:" + email);
    }
}
