package com.codecool.hccrm.validation.implementations;

/**
 * Created by prezi on 2017. 02. 07..
 */

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.validation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        SignUpDTO dto = (SignUpDTO) obj;
        return dto.getPassword().equals(dto.getMatchingPassword());
    }
}
