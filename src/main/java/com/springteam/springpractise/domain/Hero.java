/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author siux
 */
public class Hero {
    
    private Long id;
    private String name;
    private BigDecimal power;
    private List<String> weaknesses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name=" + name + ", power=" + power + ", weaknesess=" + weaknesses + '}';
    }
    
    
    
    
}
