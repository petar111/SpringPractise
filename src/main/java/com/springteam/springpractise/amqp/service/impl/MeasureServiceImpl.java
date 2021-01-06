/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.amqp.service.impl;

import com.springteam.springpractise.amqp.service.MeasureService;
import org.springframework.stereotype.Service;

/**
 *
 * @author siux
 */
@Service
public class MeasureServiceImpl implements MeasureService{

    @Override
    public String sendMeasurmentInfo(String measure) {
        switch(measure) {
            case "KG":
                return "Kilograms";
            case "Gr":
                return "Grams";
            default:
                return "Measure unit not reckognized";
        }
    }
    
}
