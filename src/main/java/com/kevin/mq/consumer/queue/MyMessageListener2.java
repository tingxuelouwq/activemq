package com.kevin.mq.consumer.queue;

public class MyMessageListener2 {

    public void handleMessage(String message) {
        System.out.println("通过handleMessage()接收到消息:" + message);
    }

    public void receiveMessage(String message) {
        System.out.println("通过receiveMessage()接收到消息:" + message);
    }
}
