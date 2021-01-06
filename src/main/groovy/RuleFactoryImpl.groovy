/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.springteam.springpractise.groovy.rule.factory.impl

import com.springteam.springpractise.groovy.rule.factory.RuleFactory
import org.springframework.stereotype.Component


/**
 *
 * @author siux
 */
@Component
class RuleFactoryImpl implements RuleFactory {
	Rule getPriceCategoryRule(){
            
            Rule rule = new Rule();
            
            rule.singleHit = true;
            
            rule.conditions = [{object, price -> object.price >= price}, {object, price -> object.price <= price}];
            rule.actions = [{object, priceCategory -> object.priceCategory = priceCategory}];
            
            rule.params = [[0,1,'Cheap'],
                           [2,3,'Moderate'],
                           [3,100000,'Expensive']];
                       
            return rule;
        }
}

