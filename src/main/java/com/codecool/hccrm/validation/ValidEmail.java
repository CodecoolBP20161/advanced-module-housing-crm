package com.codecool.hccrm.validation;

import com.codecool.hccrm.validation.implementations.EmailValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Invalid email";
}
