package com.codecool.hccrm.validation.implementations;

import com.codecool.hccrm.service.UserService;
import com.codecool.hccrm.validation.ValidEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dorasztanko on 2017.02.18..
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    @Autowired
    UserService userService;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {

    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        return (validateEmail(email)) && userService.findFirstByEmail(email) == null;

    }
    private boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
