package com.kevin.mq.consumer.queue;

import com.kevin.domain.Email;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MyMessageListener4 implements MessageListener {

    private MessageConverter messageConverter;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
//                Object obj = objectMessage.getObject();
//                Email email = (Email) obj;
                Email email = (Email) messageConverter.fromMessage(message);
                System.out.println("接收到一个ObjectMessage，包含Email对象:" + email);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public MessageConverter getMessageConverter() {
        return messageConverter;
    }

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }
}
