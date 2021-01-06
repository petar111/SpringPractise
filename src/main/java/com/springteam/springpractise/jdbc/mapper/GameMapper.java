/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.mapper;

import com.springteam.springpractise.domain.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author siux
 */
public class GameMapper implements RowMapper<Game>{

    @Override
    public Game mapRow(ResultSet rs, int i) throws SQLException {
        Game result = new Game();
        result.setId(rs.getLong("id"));
        result.setOutcome(rs.getString("outcome"));
        
        return result;
    }
    
}
