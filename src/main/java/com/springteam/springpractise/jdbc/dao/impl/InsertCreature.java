/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.dao.impl;

import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 *
 * @author siux
 */


// THERE IS BachedSqlUpdate also !!!!!
public class InsertCreature extends SqlUpdate{

    private static final String SQL = "insert into creature"
            + " (name, locked, premium, price, date_pushed_in_realm) values (:name, :locked, :premium, :price, :date_pushed_in_realm)";
    
    
    
    @Autowired
    public InsertCreature(DataSource dataSource) {
        super(dataSource, SQL);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("locked", Types.TINYINT));
        super.declareParameter(new SqlParameter("premium", Types.TINYINT));
        super.declareParameter(new SqlParameter("price", Types.NUMERIC));
        super.declareParameter(new SqlParameter("date_pushed_in_realm", Types.DATE));
        
        super.setGeneratedKeysColumnNames("id");
        super.setReturnGeneratedKeys(true);
    }
    
    
    
    
}
