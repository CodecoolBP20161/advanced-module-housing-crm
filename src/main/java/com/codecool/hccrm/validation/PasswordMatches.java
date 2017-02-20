package com.codecool.hccrm.validation;

import com.codecool.hccrm.validation.constraint.PasswordMatchesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by prezi on 2017. 02. 07..
 * Last edited by dorasztanko on 2017.02.19..
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Passwords are not matching.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
