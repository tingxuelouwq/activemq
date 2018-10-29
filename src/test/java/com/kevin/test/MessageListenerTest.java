package com.kevin.test;

import com.kevin.mq.consumer.queue.MyMessageConsumer;
import com.kevin.mq.producer.queue.MyMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class MessageListenerTest {

    @Autowired
    private MyMessageProducer producer;

    @Autowired
    @Qualifier("queueDestination2")
    private Destination queue2;

    /**
     * 测试消息监听器
     * 1、生产者向队列queue2发送消息
     * 2、MessageListener监听队列，并消费消息
     */
    @Test
    public void testProducer() {
        producer.sendMessage(queue2, "hello world");
    }
}
