/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.jpa.repository.impl;

import com.springteam.springpractise.db.entity.CreatureEntity;
import com.springteam.springpractise.db.jpa.repository.CreatureRepository;
import com.springteam.springpractise.domain.Creature;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siux
 */
@Repository
public class CreatureJpaRepositoryImpl implements CreatureRepository{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<CreatureEntity> findById(Long id) {
        
        
        Query q = em.createQuery("select c from CreatureEntity c where c.id = :id");
        q.setParameter("id", id);
        
        CreatureEntity result = (CreatureEntity)q.getResultList().get(0);
        
        return Optional.ofNullable(result);
    }

    @Override
    public List<CreatureEntity> findAll() {
        Query q = em.createNamedQuery(CreatureEntity.FIND_ALL);
        
        return q.getResultList();
    }

    @Override
    public void save(CreatureEntity creatureEntity) {
        em.persist(creatureEntity);
    }

    @Override
    public Optional<CreatureEntity> findByName(String name) {
        
        Query q = em.createQuery("Select c from CreatureEntity c where c.name = :name");
        q.setParameter("name", name);
        
        CreatureEntity result = (CreatureEntity) q.getSingleResult();
        
        return Optional.of(result);
    }

    @Override
    public List<CreatureEntity> findAllByNameStartsWith(String nameStart) {
        
        Query q = em.createQuery("Select c from CreatureEntity c where c.name like concat(:nameStart, '%') ");
        q.setParameter("nameStart", nameStart);
        
        List<CreatureEntity> result = q.getResultList();
        
        return result;
        
    }
    
    
    
}
