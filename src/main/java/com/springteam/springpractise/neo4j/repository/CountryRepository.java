/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.neo4j.repository;

import com.springteam.springpractise.neo4j.node.Country;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siux
 */
@Repository
public interface CountryRepository extends Neo4jRepository<Country, String>{
    
    
    Country findByName(String name);
    
    @Query("match (n:Country) where n.militaryPower < $militaryPower return n")
    List<Country> findByMilitaryPowerLessThan(@Param("militaryPower") int militaryPower);
    
}
