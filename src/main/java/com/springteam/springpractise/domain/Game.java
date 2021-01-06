/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author siux
 */
public class Game {

    private Long id;
    private String outcome;

    public Game() {
    }

    public Game(Long id, String outcome) {
        this.id = id;
        this.outcome = outcome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", outcome=" + outcome + '}';
    }

    public Set<String> getReadersOfBooks(Collection<String> readers, Collection<String> books, Date date) {
        Set<String> result = new HashSet<>();
//        Map<String, Collection<String>> data = dataService.getBooksReadOn(date);
        Map<String, Collection<String>> data = new HashMap<>();
        final Set<Map.Entry<String, Collection<String>>> entries = data.entrySet().stream()
                .filter(e -> readers.contains(e.getKey()))
                .collect(Collectors.toSet());
        for (Map.Entry<String, Collection<String>> e : entries) {
            for (String bookId : books) {
                if (e.getValue().contains(bookId)) {
                    result.add(e.getKey());
                }
            }
        }
        return result;
    }

}
