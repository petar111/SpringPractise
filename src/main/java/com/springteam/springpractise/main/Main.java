/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.main;

import com.springteam.springpractise.aop.target.Agent;
import com.springteam.springpractise.aop.advice.AgentDecorator;
import com.springteam.springpractise.aop.pointcut.SimpleStaticPointcut;
import com.springteam.springpractise.aop.target.DoubleAgent;
import com.springteam.springpractise.config.MyApplicationConfiguration;
import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.service.CreatureService;
import com.springteam.springpractise.db.metadata.MetadataService;
import com.springteam.springpractise.domain.Creature;
import com.springteam.springpractise.jdbc.dao.GameDao;
import com.springteam.springpractise.jdbc.dao.impl.GetCreaturePriceTotal;
import com.springteam.springpractise.jdbc.dao.impl.InsertCreature;
import com.springteam.springpractise.jdbc.mapper.CreatureMapper;
import com.springteam.springpractise.jdbc.mapper.GameMapper;
import com.springteam.springpractise.publisher.MessagePublisher;
import com.springteam.springpractise.service.SpringWelcomeService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.aopalliance.aop.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author siux
 */
@Component
public class Main {
    
//    private SpringWelcomeService springWelcomeService;
//    private String mainLabel;
    private GameDao gameDao;
    private final MetadataService metadataService;
    private final NamedParameterJdbcTemplate jdbc;
    private final DataSource dataSource;
//    private final SessionFactory hibernateSessionFactory;
    

//    @Autowired
//    public Main(/*SpringWelcomeService springWelcomeService, String mainLabel, */GameDao gameDao) {
////        this.springWelcomeService = springWelcomeService;
////        this.mainLabel = mainLabel;
//        this.gameDao = gameDao;
//    }

//    @Autowired
//    public void setSpringWelcomeService(SpringWelcomeService springWelcomeService) {
//        this.springWelcomeService = springWelcomeService;
//    }
//
//    @Autowired
//    public void setMainLabel(String mainLabel) {
//        this.mainLabel = mainLabel;
//    }
    


    public Main(MetadataService metadataService,
            NamedParameterJdbcTemplate jdbc,
            DataSource dataSource
//            SessionFactory hibernateSessionFactory
            )
    {
        this.metadataService = metadataService;
        this.jdbc = jdbc;
        this.dataSource = dataSource;
//        this.hibernateSessionFactory = hibernateSessionFactory;
    }
    
    
    
    
    
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(MyApplicationConfiguration.class);
//        ctx.refresh();
//        
//        Main main = ctx.getBean(Main.class);
//        
//        System.out.println(main.springWelcomeService.getHelloMessage());
//        
//        ctx.close();


//        File file = File.createTempFile("test", "txt");
//
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:application-context.xml");
//        ctx.refresh();
//        
//        Resource res = ctx.getResource("classpath:test.txt");
//        System.out.println(res.getClass());
//        
//        MessagePublisher messagePublisher = (MessagePublisher)ctx.getBean("messagePublisher");
//        Main main = ctx.getBean(Main.class);
//        
//        System.out.println("Main label: " + main.mainLabel);
//        
//        messagePublisher.publish("Yeyo");
//        
//        ctx.close();


//        GenericGroovyApplicationContext ctx = new GenericGroovyApplicationContext("classpath:AppConfig.groovy");
//        
////        ctx.refresh();
//        
//        Main main = (Main)ctx.getBean("main");
//        
//        System.out.println(main.springWelcomeService.getHelloMessage());
//        
//        ctx.close();


//        ProxyFactory pf = new ProxyFactory();
//        
//        pf.addAdvice(new AgentDecorator());
//        pf.setTarget(new Agent());
//        
//        
//        Agent proxy = (Agent)pf.getProxy();
//        
//        proxy.speak();
//        Pointcut pointcut = new SimpleStaticPointcut();
//        Advice advice = new AgentDecorator();
//        
//        PointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
//        
//        ProxyFactory pf = new ProxyFactory();
//        pf.addAdvisor(advisor);
//        pf.setTarget(new Agent());
//        
//        Agent proxy = (Agent)pf.getProxy();
//        proxy.speak();



        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfiguration.class);
        
        Main main = ctx.getBean(Main.class);
        
//        System.out.println(main.gameDao.findAll().toString());
//        System.out.println(main.metadataService.getTableNames());
//        System.out.println(main.metadataService.getColumnNamesByTableName("Game"));
        
        String sql = "SELECT * FROM creature WHERE id = :creatureId";
        
        Map<String, Object> names = new HashMap<>();
        names.put("creatureId", 1);
        
        List <Creature> creatures = main.jdbc.query(sql, names, new CreatureMapper());
        
//        main.jdbc.q
        System.out.println(creatures);
        
        
//        InsertCreature ic = new InsertCreature(main.dataSource);
//        
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", "Nightmare");
//        params.put("locked", true);
//        params.put("premium", false);
//        params.put("price", new BigDecimal(3.33));
//        params.put("date_pushed_in_realm", null);
//        
//        
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        
//        ic.updateByNamedParam(params, keyHolder);
//        
//        
//        System.out.println("New generated id for creature is " + keyHolder.getKey().longValue());
        
//        GetCreaturePriceTotal gtpt = new GetCreaturePriceTotal(main.dataSource);
//        
//        System.out.println(gtpt.execute());
//        
//        Session session =  main.hibernateSessionFactory.openSession();
//        
//        
//        EntityManager entityManager = main.hibernateSessionFactory.createEntityManager();
//        
//        entityManager.getTransaction().begin();
//                
//        System.out.println("Creating entity...");
//        CreatureEntity entity = new CreatureEntity();
//        entity.setDatePushedInRealm(null);
//        entity.setName("Azure Keeper");
//        entity.setIsLocked(true);
//        entity.setIsPremium(false);
//        entity.setPrice(new BigDecimal(44.01));
        
//        session.save(entity);
        
        
//        System.out.println(session.find(CreatureEntity.class, 7L));
        
        
        
        
//        
//        System.out.println("Persisting entity...");
//        entityManager.persist(entity);
//        
//        
//        
//        entityManager.getTransaction().commit();
//        System.out.println("Closing entity manager...");
//        entityManager.close();
//        main.hibernateSessionFactory.close();
        
        
        
        ctx.close();


    }
}
