/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jms.sender.impl;

import com.springteam.springpractise.jms.sender.MessageSender;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 *
 * @author siux
 */
@Service
public class SimpleMessageSender implements MessageSender{
    
    private final JmsTemplate jmsTemplate;

    @Autowired
    public SimpleMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    

    @Override
    public void sendMessage(String message) {
        jmsTemplate.setDeliveryDelay(5000L);
        
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session sn) throws JMSException {
                TextMessage textMessage = sn.createTextMessage(message);
                
                System.out.println("Sending message: " + message);
                
                return textMessage;
            }
        });
    }
    
}
