/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.entity;

import com.springteam.springpractise.validator.NameStartsWithCapitalLetter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author siux
 */
@Entity
@Table(name = "creature")
@NamedQueries({
    @NamedQuery(name = "Creature.findAll", query = "select c from CreatureEntity c")
})
public class CreatureEntity implements Serializable{
    public static final String FIND_ALL = "Creature.findAll";
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    @NameStartsWithCapitalLetter
    private String name;
    
    @Column(name = "locked")
    private boolean isLocked;
    
    @Column(name = "premium")
    private boolean isPremium;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "date_pushed_in_realm")
    private Date datePushedInRealm;

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

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDatePushedInRealm() {
        return datePushedInRealm;
    }

    public void setDatePushedInRealm(Date datePushedInRealm) {
        this.datePushedInRealm = datePushedInRealm;
    }

    @Override
    public String toString() {
        return "CreatureEntity{" + "id=" + id + ", name=" + name + ", isLocked=" + isLocked + ", isPremium=" + isPremium + ", price=" + price + ", datePushedInRealm=" + datePushedInRealm + '}';
    }
    
    
    
    
    
}
