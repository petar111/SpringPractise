/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.listener;

import com.springteam.springpractise.event.MessageEvent;
import org.springframework.context.ApplicationListener;

/**
 *
 * @author siux
 */
public class MessageEventListener implements ApplicationListener<MessageEvent>{

    @Override
    public void onApplicationEvent(MessageEvent e) {
        System.out.println("Received message: " + e.getMessage());
    }
    
}
