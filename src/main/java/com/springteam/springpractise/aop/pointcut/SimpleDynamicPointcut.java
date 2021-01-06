/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.aop.pointcut;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 *
 * @author siux
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut{

    @Override
    public boolean matches(Method method, Class<?> type, Object... os) {
        return method.getName().matches("speak");
    }

    
    //BELOW IS STATIC CHECK
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return super.matches(method, targetClass); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public ClassFilter getClassFilter() {
        return super.getClassFilter(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
