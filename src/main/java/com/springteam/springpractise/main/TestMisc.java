/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.domain.Hero;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author siux
 */
@Component
public class TestMisc {
    
    private final Hero hero;

    
    @Autowired
    public TestMisc(Hero hero) {
        this.hero = hero;
    }
    
    
    
    
    
    public static void main(String[] args) throws ScriptException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        TestMisc test = ctx.getBean(TestMisc.class);
        
        
        System.out.println(test.hero);
        
        ctx.close();
        
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");
        
        engine.eval("print('Hello JavaScript')");
        
        
    }
}
