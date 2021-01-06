/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author siux
 */
public class CreatureNameCapitalLetterValidator implements ConstraintValidator<NameStartsWithCapitalLetter, String>{

    @Override
    public void initialize(NameStartsWithCapitalLetter a) {
        ConstraintValidator.super.initialize(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
       if(!Character.isAlphabetic(t.charAt(0))){
           cvc.buildConstraintViolationWithTemplate("The does not start with letter").addConstraintViolation();
           return false;
       }
        
       if(Character.toUpperCase(t.charAt(0)) != t.charAt(0)){
           cvc.buildConstraintViolationWithTemplate("The first letter is on in capital").addConstraintViolation();
           return false;
       }
       
       return true;
    }
    
}
