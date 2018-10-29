package com.kevin.test;

import com.kevin.mq.producer.topic.MyTopicPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class SessionAwareMessageListenerTest {

    @Autowired
    private MyTopicPublisher publisher;

    @Autowired
    @Qualifier("topicDestination2")
    private Destination topicDestination2;

    @Test
    public void testSessionAwareMessageListener() {
        publisher.publish(topicDestination2, "测试SessionAwareMessageListener");
    }
}
