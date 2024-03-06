package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MinMaxPartInventoryValidator implements ConstraintValidator<ValidMinMaxPartInventory, Part> {
    @Autowired
    private ApplicationContext context;

    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidMinMaxPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //isValid function overrides a method from the superclass which is an example of polymorphism
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PartServiceImpl repo = myContext.getBean(PartServiceImpl.class);
        double sumPartsPrice = 0;
        if (part.getId() != 0) {
            Part myPart = repo.findById((int) part.getId());

            if (part.getInv() >= part.getMinInventory() && part.getInv()<= part.getMaxInventory()) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return true;
        }
    }
}