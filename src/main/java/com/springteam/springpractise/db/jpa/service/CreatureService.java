/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.jpa.service;

import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.domain.Creature;
import java.util.List;

/**
 *
 * @author siux
 */
public interface CreatureService {
    CreatureEntity findById(Long id);
    List<CreatureEntity> findAll();
    void save(CreatureEntity creatureEntity);
    CreatureEntity findByName(String name);
    void sayHello();

    public List<CreatureEntity> findAllByNameStartsWith(String nameStart);
}
