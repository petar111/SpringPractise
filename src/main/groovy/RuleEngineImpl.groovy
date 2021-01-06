/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.stereotype.Component

import com.springteam.springpractise.groovy.rule.engine.RuleEngine;
/**
 *
 * @author siux
 */
@Component
class RuleEngineImpl implements RuleEngine {
	
    void run(Rule rule, Object o){
        def exit = false;
        
        
        rule.params.each { ArrayList param ->
            
            def paramIndex = 0;
            def success = true;
            
            if(!exit){
                rule.conditions.each {
            
                    success = success && it(object, param[paramIndex]);
                
                    paramIndex++;
                };
            }
            
            
            if(success && !exit){
                
                rules.actions.each {
                    it(object, param[paramIndex]);
                    paramIndex++;
                }

            }
            
            if(rule.singleHit){
                exit = true;
            }
            
        };
        
        
    }
}

