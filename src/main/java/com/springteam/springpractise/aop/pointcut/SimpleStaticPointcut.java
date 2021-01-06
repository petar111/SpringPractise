/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.aop.pointcut;

import com.springteam.springpractise.aop.target.Agent;
import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 *
 * @author siux
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut{

    @Override
    public boolean matches(Method method, Class<?> type) {
        return method.getName().matches("speak");
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == Agent.class;
    }
    
    
    
}
