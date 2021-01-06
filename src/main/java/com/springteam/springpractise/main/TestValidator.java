/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.service.CreatureService;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


/**
 *
 * @author siux
 */

@Component
public class TestValidator {
    
    private final Validator validator;
    private final CreatureService creatureService;
    
    @Autowired
    public TestValidator(Validator validator, CreatureService creatureService){
        this.validator = validator;
        this.creatureService = creatureService;
    }
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        TestValidator testValidator = ctx.getBean(TestValidator.class);
        
        CreatureEntity creature = testValidator.creatureService.findById(1L);
        
        CreatureEntity wrong = new CreatureEntity();
        wrong.setName("tralalal");
        
        Set<ConstraintViolation<CreatureEntity>> violations =  testValidator.validator.validate(creature);
        
        System.out.println("Violations for creature:");
        violations.forEach(v -> System.out.println(v.getMessage()));
        
        Set<ConstraintViolation<CreatureEntity>> violationsWrong =testValidator.validator.validate(wrong);
        
        System.out.println("Violations for wrong creature:");
        violationsWrong.forEach(v -> System.out.println(v.getMessage()));
        
        ctx.close();
    }
}
