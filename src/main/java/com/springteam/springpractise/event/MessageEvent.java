/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author siux
 */
public class MessageEvent extends ApplicationEvent{
    
    private final String message;
    
    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    
    
}
