/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author siux
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.springteam.springpractise.db.jpa.repository.impl"})
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.springteam.springpractise.db.jpa.service.impl",
    "com.springteam.springpractise.db.entity",
    "com.springteam.springpractise.db.jpa.repository.impl"})
public class TestServiceConfig {
    
    @Autowired
    @Qualifier("testDataSource")
    private DataSource dataSource;
    
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager();
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }
    
    @Bean 
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        
        result.setJpaVendorAdapter(jpaVendorAdapter());
        result.setPackagesToScan("com.springteam.springpractise.db.entity");
        result.setDataSource(dataSource);
        
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        
        
        result.setJpaProperties(hibernateProperties);
        
        result.afterPropertiesSet();
        return result.getNativeEntityManagerFactory();
    }
    
}
