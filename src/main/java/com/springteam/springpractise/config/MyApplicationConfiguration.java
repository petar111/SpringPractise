/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.config;


import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.support.Neo4jRepositoryFactoryBean;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author siux
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = {"com.springteam.springpractise.neo4j.repository"},
                                            repositoryFactoryBeanClass = Neo4jRepositoryFactoryBean.class)
@ComponentScan(basePackages = {"com.springteam.springpractise.service",
                               "com.springteam.springpractise.main", 
                               "com.springteam.springpractise.jdbc.dao.impl",
                               "com.springteam.springpractise.db.metadata",
                               "com.springteam.springpractise.db.jpa.service.impl",
                               "com.springteam.springpractise.db.jpa.repository.impl",
                               "com.springteam.springpractise.neo4j.repository"
})
@PropertySource("classpath:db.properties")
@PropertySource("classpath:hibernate.properties")
@PropertySource("classpath:neo4j-config.properties")
@ImportResource({"classpath:application-context.xml"})
@Import(JmsAppConfig.class)
public class MyApplicationConfiguration extends AbstractNeo4jConfig{
    
    @Value("${jdbc.url}")
    private String dbUrl;
    @Value("${jdbc.user}")
    private String dbUsername;
    @Value("${jdbc.password}")
    private String dbPassword;
    @Value("${jdbc.driver}")
    private String dbDriver;
    
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    
    @Bean(name = "productionDataSource")
    public DataSource dataSource(){
         
        DriverManagerDataSource result = new DriverManagerDataSource();
        result.setDriverClassName(dbDriver);
        result.setUrl(dbUrl);
        result.setUsername(dbUsername);
        result.setPassword(dbPassword);
        
        return result;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(){
        
        JdbcTemplate result = new JdbcTemplate();
        result.setDataSource(dataSource());
        
        return result;
    }
    
    @Bean
    public NamedParameterJdbcTemplate namedJdbc(){
        NamedParameterJdbcTemplate result = new NamedParameterJdbcTemplate(dataSource());
        return result;
    }
    
    
//    @Bean
//    public SessionFactory sessionFactory() throws IOException{
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.springteam.springpractise.db.entity");
//        
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", hibernateDialect);
//   
//        sessionFactory.setHibernateProperties(hibernateProperties);
//        sessionFactory.afterPropertiesSet();
//        
//        return sessionFactory.getObject();
//    }
    
    
//    @Bean PlatformTransactionManager transactionManager() throws IOException{
//        HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory());
//        return manager;
//    }
    
    
    @Bean PlatformTransactionManager transactionManager() throws IOException{
        JpaTransactionManager manager = new JpaTransactionManager(managerFactory());
        return manager;
    }
    
    @Bean JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }
    
    @Bean
    public EntityManagerFactory managerFactory(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.springteam.springpractise.db.entity");
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", hibernateDialect);
        
        
        emf.setJpaProperties(hibernateProperties);
        
        
        emf.afterPropertiesSet();
        return emf.getNativeEntityManagerFactory();
    }
    
    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
    
    @Value("${neo4j.url}")
    private String neo4jUrl;
    @Value("${neo4j.username}")
    private String neo4jUsername;
    @Value("${neo4j.password}")
    private String neo4jPassword;
    
    
    //Neo4j Config
    @Override
    @Bean
    public Driver driver() {
        Driver result = GraphDatabase.driver(neo4jUrl, AuthTokens.basic(neo4jUsername, neo4jPassword));
        return result;
    }
    


}
