package com.codecool.hccrm.validation;

import com.codecool.hccrm.validation.constraint.PhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dorasztanko on 2017.02.19..
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Documented
public @interface Phone {
    String message() default "{Phone}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

