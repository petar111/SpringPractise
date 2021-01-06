/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.config;

import java.util.HashMap;
import java.util.Map;
import javax.jms.ConnectionFactory;
import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.core.remoting.impl.netty.TransportConstants;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;
import org.hornetq.jms.client.HornetQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 *
 * @author siux
 */
@Configuration
@EnableJms
@ComponentScan(basePackages = {"com.springteam.springpractise.jms.listener",
                                "com.springteam.springpractise.jms.sender.impl",
                                "com.springteam.springpractise.main"})
public class JmsAppConfig {

    @Bean
    public HornetQQueue springpractise(){
        return new HornetQQueue("springpractise");
    }
    
    @Bean(name = "jmsConnectionFactory")
    public ConnectionFactory connectionFactory(){
        Map<String, Object> connectionDetails = new HashMap<>();
        connectionDetails.put(TransportConstants.HOST_PROP_NAME, "127.0.0.1");
        connectionDetails.put(TransportConstants.PORT_PROP_NAME, "5445");
        
        TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName(),
                connectionDetails);
        
        return new HornetQJMSConnectionFactory(false, transportConfiguration);
    }
    
    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setConcurrency("3-5");
        
        return jmsListenerContainerFactory;
    }
    
    
    @Bean 
    public JmsTemplate jmsTemplate(){
        JmsTemplate jms = new JmsTemplate();
        jms.setConnectionFactory(connectionFactory());
        jms.setDefaultDestination(springpractise());
        
        return jms;
    }
    
}
