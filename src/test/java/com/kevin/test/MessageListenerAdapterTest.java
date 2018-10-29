package com.kevin.test;

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
public class MessageListenerAdapterTest {

    @Autowired
    private MyMessageProducer producer;

    @Autowired
    @Qualifier("queueDestination3")
    private Destination destination;

    @Test
    public void testMessageListenerAdapter() {
        producer.sendMessage(destination, "测试MessageListenerAdapter");
    }
}
