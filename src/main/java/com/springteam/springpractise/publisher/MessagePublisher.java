/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.publisher;

import com.springteam.springpractise.event.MessageEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;

/**
 *
 * @author siux
 */
public class MessagePublisher implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
    }

    public void publish(String message){
        applicationContext.publishEvent(new MessageEvent(this, message));
    }
    
    
    
}
