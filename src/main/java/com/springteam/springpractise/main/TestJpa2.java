/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.db.jpa.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author siux
 */
@Component
public class TestJpa2 {
    
    private final CreatureService creatureService;

    @Autowired
    public TestJpa2(CreatureService creatureService) {
        this.creatureService = creatureService;
    }
    
    
    
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        TestJpa2 main = ctx.getBean(TestJpa2.class);
        
        System.out.println(main.creatureService.findById(1L));
        
        
        System.out.println(main.creatureService.findAll());
        
        ctx.close();
    }
    
}
