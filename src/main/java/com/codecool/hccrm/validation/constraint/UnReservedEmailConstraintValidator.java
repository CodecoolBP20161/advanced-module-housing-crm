package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.service.UserService;
import com.codecool.hccrm.validation.UnReservedEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dorasztanko on 2017.02.20..
 */
public class UnReservedEmailConstraintValidator implements ConstraintValidator<UnReservedEmail, String> {

    @Autowired
    UserService userService;

    public void initialize(UnReservedEmail constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return notRegisteredEmail(email);
    }

    private boolean notRegisteredEmail(String email) {
        return userService.findFirstByEmail(email) == null;
    }
}
