package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.validation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dorasztanko on 2017.02.19..
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneField == null || phoneField.isEmpty()) {
            return false;
        }
        return phoneField.matches("[0-9()-]*");
    }
}
