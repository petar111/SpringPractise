/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.config.JmsAppConfig;
import com.springteam.springpractise.jms.sender.MessageSender;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author siux
 */
@Component
public class TestJms {
    private final MessageSender messageSender;

    @Autowired
    public TestJms(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    
    
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        TestJms test = ctx.getBean(TestJms.class);
        
        test.messageSender.sendMessage("Hello");
        test.messageSender.sendMessage("Got any messages yet?");
        
        System.in.read();
        
        ctx.close();
    }
    
}
