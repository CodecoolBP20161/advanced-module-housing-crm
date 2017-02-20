package com.codecool.hccrm.validation;

import com.codecool.hccrm.validation.constraint.PersonNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by balag3 on 2017.02.20..
 */
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PersonNameValidator.class)
@Documented
public @interface ValidPersonName {

    String message() default "Invalid name.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
