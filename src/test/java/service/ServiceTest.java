/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.springteam.springpractise.config.TestDataConfig;
import com.springteam.springpractise.config.TestServiceConfig;
import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.repository.impl.CreatureJpaRepositoryImpl;
import com.springteam.springpractise.db.jpa.service.CreatureService;
import com.springteam.springpractise.db.jpa.service.impl.CreatureServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 *
 * @author siux
 */
@SpringJUnitConfig(classes = {TestDataConfig.class, TestServiceConfig.class})
public class ServiceTest {
    
    @Autowired
    private CreatureService creatureService;
    
    @PersistenceContext
    private EntityManager em;
    
    public ServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    @DisplayName("Expected to return creature with name Martyr.")
    @SqlGroup({
            @Sql(
                  value = "classpath:db/testdata.sql",
                  executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                  config = @SqlConfig(encoding = "utf-8", separator = ";")
            ),
            @Sql(
                  value = "classpath:db/cleanup.sql",
                  executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
            )
    }
    )
    public void testFindById(){
        
        
        CreatureEntity ce = creatureService.findById(1L);
        
        assertEquals("Martyr", ce.getName());
        
    }
    
    
    
    @Test
    @SqlGroup({
            @Sql(
                  value = "classpath:db/testdata.sql",
                  executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                  config = @SqlConfig(encoding = "utf-8", separator = ";")
            ),
            @Sql(
                  value = "classpath:db/cleanup.sql",
                  executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
            )
    }
    )
    @DisplayName("Expected to return list of 5 creatures.")
    public void testFindAll(){
        
        
        List<CreatureEntity> creatures = creatureService.findAll();
        
        assertEquals(5, creatures.size());
        
    }
    
    
    
    @Test
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
             scripts = "classpath:db/testdata.sql",
             config = @SqlConfig(encoding = "utf-8")),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
             scripts = "classpath:db/cleanup.sql",
             config = @SqlConfig(encoding = "utf-8"))
    })
    public void testInsertCreature(){
        CreatureEntity ce = new CreatureEntity();
        
        ce.setDatePushedInRealm(null);
        ce.setIsLocked(false);
        ce.setIsPremium(true);
        ce.setPrice(BigDecimal.ONE);
        ce.setName("Dungeon keeper");
        
        creatureService.save(ce);
        
        List<CreatureEntity> creatures = creatureService.findAll();
        
        assertEquals(6, creatures.size());
        
    }
    
    
    @Test
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
             scripts = "classpath:db/testdata.sql",
             config = @SqlConfig(encoding = "utf-8")),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
             scripts = "classpath:db/cleanup.sql",
             config = @SqlConfig(encoding = "utf-8"))
    })
    public void testFindByName(){
        CreatureEntity ce = creatureService.findByName("The One From The Abyss");
        
        assertEquals("The One From The Abyss", ce.getName());
    }
    
    
    
    @Test
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
             scripts = "classpath:db/testdata.sql",
             config = @SqlConfig(encoding = "utf-8")),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
             scripts = "classpath:db/cleanup.sql",
             config = @SqlConfig(encoding = "utf-8"))
    })
    public void testFindAllByNameStartsWith(){
        
        List<CreatureEntity> creatures = creatureService.findAllByNameStartsWith("Ma");
        
        assertEquals(1, creatures.size());
        
        
        List<CreatureEntity> creatures2 = creatureService.findAllByNameStartsWith("The One");
        
        assertEquals(1, creatures2.size());
        
    }
    
    
    

}
