/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.jpa.service.impl;

import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.repository.CreatureRepository;
import com.springteam.springpractise.db.jpa.service.CreatureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author siux
 */
@Service("creatureService")
public class CreatureServiceImpl implements CreatureService{
    
    private final CreatureRepository creatureRepository;

    @Autowired
    public CreatureServiceImpl(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    public CreatureEntity findById(Long id) {
        return creatureRepository.findById(id).orElseThrow(() -> new RuntimeException("Creature with id " + id + " not found!"));
    }

    @Override
    public List<CreatureEntity> findAll() {
        return creatureRepository.findAll();
    }

    @Override
    public void sayHello() {
        System.out.println("Hello from creature service.");
    }

    @Override
    @Transactional
    public void save(CreatureEntity creatureEntity) {
        creatureRepository.save(creatureEntity);
    }

    @Override
    public CreatureEntity findByName(String name) {
        return creatureRepository.findByName(name).orElseThrow(() -> new RuntimeException("Creature with name " + name + " not found."));
    }

    @Override
    public List<CreatureEntity> findAllByNameStartsWith(String nameStart) {
        return creatureRepository.findAllByNameStartsWith(nameStart);
    }
    
}
