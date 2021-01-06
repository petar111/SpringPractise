/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.jdbc.dao;

import com.springteam.springpractise.domain.Game;
import java.util.List;

/**
 *
 * @author siux
 */
public interface GameDao {
    List<Game> findAll();
}
