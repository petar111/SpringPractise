/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.jpa.service.impl;

import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.repository.CreatureRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author siux
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class CreatureServiceImplTest {
    
    private List<CreatureEntity> creatures;
    
    public CreatureServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        CreatureEntity creature1 = new CreatureEntity();
        creature1.setId(1L);
        creature1.setName("Creature1 test");
        
        CreatureEntity creature2 = new CreatureEntity();
        creature2.setId(2L);
        creature2.setName("Creature2 test");
        
        creatures = new ArrayList<>();
        
        creatures.add(creature1);
        creatures.add(creature2);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class CreatureServiceImpl.
     */
    @Test
    public void testFindById() {
        
        
        CreatureEntity expectedCreature = new CreatureEntity();
        expectedCreature.setId(1L);
        
        CreatureRepository creatureRepository = Mockito.mock(CreatureRepository.class);
        Mockito.when(creatureRepository.findById(1L)).thenReturn(Optional.of(expectedCreature));
        
        CreatureServiceImpl creatureServiceImpl = new CreatureServiceImpl(creatureRepository);
        
        CreatureEntity actualCreature =  creatureServiceImpl.findById(1L);
        
        
        assertEquals(expectedCreature, actualCreature);
    }

    /**
     * Test of findAll method, of class CreatureServiceImpl.
     */
    @Test
    public void testFindAll() {
        
        CreatureRepository creatureRepository = Mockito.mock(CreatureRepository.class);
        Mockito.when(creatureRepository.findAll()).thenReturn(this.creatures);
        
        
        CreatureServiceImpl creatureServiceImpl = new CreatureServiceImpl(creatureRepository);
        
        List<CreatureEntity> actualCreatures =  creatureServiceImpl.findAll();
        
        
        assertEquals(this.creatures, actualCreatures);
        
    }

    /**
     * Test of sayHello method, of class CreatureServiceImpl.
     */
    @Test
    public void testSayHello() {
        assertEquals(true, true);
    }
    
}
