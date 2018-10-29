package com.kevin.test;

import com.kevin.mq.consumer.queue.MyMessageConsumer;
import com.kevin.mq.producer.queue.MyMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 测试P2P
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class QueueTest {

    @Autowired
    private MyMessageProducer producer;

    @Autowired
    private MyMessageConsumer consumer;

    // 测试：生产者向默认队列发送消息
    @Test
    public void testProducer() {
        String msg = "hello world";
        producer.sendMessage(msg);
    }

    // 测试：消费者从默认队列接收消息
    @Test
    public void testConsumer() {
        consumer.receive();
    }
}
