/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.service.impl;

import com.springteam.springpractise.service.SpringWelcomeService;
import org.springframework.stereotype.Service;

/**
 *
 * @author siux
 */
//@Service
public class SpringWelcomeServiceSimple implements SpringWelcomeService{

    @Override
    public String getHelloMessage() {
        return "Hello Spring Simple message.";
    }
    
}
