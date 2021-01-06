/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.neo4j.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author siux
 */
@Component
public class TestNeo4j {
    
    private final CountryRepository countryRepository;

    @Autowired
    public TestNeo4j(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        TestNeo4j test = ctx.getBean(TestNeo4j.class);
        
//        System.out.println(test.countryRepository.findAll());
        
//        System.out.println(test.countryRepository.findByName("Russia"));

        System.out.println(test.countryRepository.findByMilitaryPowerLessThan(13000));
        
        ctx.close();
    }
}
