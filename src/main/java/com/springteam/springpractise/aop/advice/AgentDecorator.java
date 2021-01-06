/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author siux
 */
public class AgentDecorator implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        
        System.out.println("Bond");
        
        Object result = mi.proceed();
        
        System.out.println("Bond");
        
        System.out.println("!");
        
        return result;
    }
    
}
