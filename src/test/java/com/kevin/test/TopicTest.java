package com.kevin.test;

import com.kevin.mq.producer.topic.MyTopicPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class TopicTest {

    @Autowired
    private MyTopicPublisher publisher;

    /**
     * 测试主题监听
     * 1、发布者向主题发布消息
     * 2、MessageListener监听主题，并消费消息
     */
    @Test
    public void testPublisher() {
        publisher.publish("hello world");
    }
}
