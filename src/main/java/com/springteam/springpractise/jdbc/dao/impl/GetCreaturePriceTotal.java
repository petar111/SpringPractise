/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.dao.impl;

import java.math.BigDecimal;
import javax.sql.DataSource;
import org.springframework.jdbc.object.SqlFunction;

/**
 *
 * @author siux
 */

// parameters in stored functions!!!!
public class GetCreaturePriceTotal extends SqlFunction<BigDecimal>{

    public GetCreaturePriceTotal(DataSource dataSource) {
        super(dataSource, "SELECT getCreaturePriceTotal()");
        compile();
    }
    
    
    
}
