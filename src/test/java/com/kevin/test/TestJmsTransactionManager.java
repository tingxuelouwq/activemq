package com.kevin.test;

import com.kevin.mq.producer.queue.MyMessageProducer4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class TestJmsTransactionManager {

    @Autowired
    private MyMessageProducer4 producer4;

    @Test
    public void testJmsTransactionManager() {
        producer4.sendMessage("测试JmsTransactionManager");
    }
}
