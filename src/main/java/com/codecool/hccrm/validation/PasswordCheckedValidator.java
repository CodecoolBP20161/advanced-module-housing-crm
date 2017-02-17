package com.codecool.hccrm.validation;

/**
 * Created by prezi on 2017. 02. 07..
 */

import com.codecool.hccrm.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCheckedValidator implements ConstraintValidator<PasswordChecked, Object> {

    @Override
    public void initialize(final PasswordChecked constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserDTO user = (UserDTO) obj;

        return user.getPassword().equals(user.getPasswordCheck());
    }

}