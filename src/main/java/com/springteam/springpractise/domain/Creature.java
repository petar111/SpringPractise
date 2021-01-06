/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.domain;

import com.springteam.springpractise.validator.NameStartsWithCapitalLetter;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author siux
 */
public class Creature {
    private Long id;
    
    @NameStartsWithCapitalLetter
    private String name;
    
    private boolean isLocked;
    private boolean isPremium;
    private BigDecimal price;
    private Date datePushedInRealm;
    
    private String priceCategory;

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }
    
    

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
        return "Creature{" + "id=" + id + ", name=" + name + ", isLocked=" + isLocked + ", isPremium=" + isPremium + ", price=" + price + ", datePushedInRealm=" + datePushedInRealm + '}';
    }
    
    
}
