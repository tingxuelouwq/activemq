package com.kevin.test;

import com.kevin.domain.Email;
import com.kevin.mq.producer.queue.MyMessageProducer3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class MessageConverterTest {

    @Autowired
    private MyMessageProducer3 producer;

    @Autowired
    @Qualifier("queueDestination6")
    private Destination destination;

    @Autowired
    @Qualifier("queueDestination7")
    private Destination destination2;

    @Autowired
    @Qualifier("queueDestination8")
    private Destination destination3;

    @Test
    public void testMessageConverter() {
        Email email = new Email("Nicholas", "关于JavaScript", "这本书不错");
        producer.sendMessage2(destination, email);
    }

    @Test
    public void testMessageConverter2() {
        Email email = new Email("Kevin", "关于MessageConverter", "详解");
        producer.sendMessage2(destination2, email);
    }

    @Test
    public void testMessageConverter3() {
        Email email = new Email("Kevin", "不使用MessageConverter", "配置messageConverter为<null/>即可");
        producer.sendMessage2(destination3, email);
    }
}
