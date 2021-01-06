/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.amqp.service.MeasureService;
import com.springteam.springpractise.config.MyApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author siux
 */

public class TestAmqp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        MeasureService service = ctx.getBean(MeasureService.class);
        
        System.out.println(service.sendMeasurmentInfo("KG"));
        
        ctx.close();
    }
}
