/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.mapper;

import com.springteam.springpractise.domain.Creature;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

/**
 *
 * @author siux
 */
public class CreatureMapper implements RowMapper<Creature>{

    @Override
    public Creature mapRow(ResultSet rs, int i) throws SQLException {
        Creature result = new Creature();
        
        result.setId(rs.getLong("id"));
        result.setName(rs.getString("name"));
        result.setIsLocked(rs.getBoolean("locked"));
        result.setIsPremium(rs.getBoolean("premium"));
        result.setPrice(rs.getBigDecimal("price"));
        result.setDatePushedInRealm(rs.getDate("date_pushed_in_realm"));
        
        return result;
    }
    
}
