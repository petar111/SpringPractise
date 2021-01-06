/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.jpa.repository;

import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.domain.Creature;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author siux
 */
public interface CreatureRepository {
    Optional<CreatureEntity> findById(Long id);
    Optional<CreatureEntity> findByName(String name);
    void save(CreatureEntity creatureEntity);
    public List<CreatureEntity> findAll();

    public List<CreatureEntity> findAllByNameStartsWith(String nameStart);
}
