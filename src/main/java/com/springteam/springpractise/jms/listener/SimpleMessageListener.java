/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author siux
 */
@Component
public class SimpleMessageListener {
    
    @JmsListener(destination = "springpractise", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message){
        TextMessage textMessage = (TextMessage) message;
        
        
        try {
            System.out.println("Received message: " + textMessage.getText());
        } catch (JMSException e) {
            System.out.println(e.toString());
        }
    }
    
    
}
