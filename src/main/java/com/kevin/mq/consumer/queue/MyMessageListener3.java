package com.kevin.mq.consumer.queue;

public class MyMessageListener3 {

    public String handleMessage(String message) {
        System.out.println("通过handleMessage()接收到消息:" + message);
        return "这是handleMessage()方法的返回值";
    }

    public String receiveMessage(String message) {
        System.out.println("通过receiveMessage()接收到消息:" + message);
        return "这是receiveMessage()方法的返回值";
    }
}
