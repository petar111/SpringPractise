/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.domain.Creature;
import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 *
 * @author siux
 */
public class TestGroovy {
    public static void main(String[] args) {
        
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        Creature cr = new Creature();
        
        cr.setPrice(BigDecimal.ONE);

        
        System.out.println(cr.getPriceCategory());
        
        ctx.close();
        
        
        
    }
}
