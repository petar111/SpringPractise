/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.dao.impl;

import com.springteam.springpractise.domain.Game;
import com.springteam.springpractise.jdbc.dao.GameDao;
import com.springteam.springpractise.jdbc.mapper.GameMapper;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siux
 */
@Repository
public class JdbcGameDao implements GameDao{
    
    private final JdbcTemplate jdbc;
    private final DataSource dataSource;

    @Autowired
    public JdbcGameDao(JdbcTemplate jdbc, DataSource dataSource) {
        this.jdbc = jdbc;
        this.dataSource = dataSource;
    }
    
    
    

    @Override
    public List<Game> findAll() {
        return jdbc.query("SELECT * FROM \"Game\"", new GameMapper());
    }
    
}
