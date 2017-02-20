package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.validation.ValidPersonName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by balag3 on 2017.02.20..
 */
public class PersonNameValidator implements ConstraintValidator<ValidPersonName, String> {
    @Override
    public void initialize(ValidPersonName validPersonName) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return name.matches("[A-Z]{1}[a-z]{0,30}");
    }
}
