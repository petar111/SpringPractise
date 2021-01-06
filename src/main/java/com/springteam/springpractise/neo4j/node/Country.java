/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.neo4j.node;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 *
 * @author siux
 */
@Node("Country")
public class Country {
    
    @Id
    private String name;
    
    @Property
    private int militaryPower;
    
    @Property
    private int population;
    
    @Relationship(direction = Relationship.Direction.OUTGOING, type = "Attacks")
    private List<Country> countriesAttacked;
    

    public Country() {
    }

    public Country(String name, int militaryPower, int population, List<Country> countriesAttacked) {
        this.name = name;
        this.militaryPower = militaryPower;
        this.population = population;
        this.countriesAttacked = countriesAttacked;
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMiliraryPower() {
        return militaryPower;
    }

    public void setMiliraryPower(int miliraryPower) {
        this.militaryPower = miliraryPower;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Country> getCountriesAttacked() {
        return countriesAttacked;
    }

    public void setCountriesAttacked(List<Country> countriesAttacked) {
        this.countriesAttacked = countriesAttacked;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", militaryPower=" + militaryPower + ", population=" + population + ", countriesAttacked=" + countriesAttacked + '}';
    }
    
    
    
}
