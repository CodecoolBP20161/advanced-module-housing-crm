package com.codecool.hccrm.validation.constraint;


import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.validation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by prezi on 2017. 02. 07..
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        SignUpDTO dto = (SignUpDTO) obj;
        return dto.getPassword().equals(dto.getMatchingPassword());
    }
}
