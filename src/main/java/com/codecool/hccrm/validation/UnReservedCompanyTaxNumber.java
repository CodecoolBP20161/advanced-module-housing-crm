package com.codecool.hccrm.validation;

import com.codecool.hccrm.validation.constraint.UnReservedCompanyTaxNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
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
@Constraint(validatedBy = UnReservedCompanyTaxNumberConstraintValidator.class)
@Documented
public @interface UnReservedCompanyTaxNumber {
    String message() default "Already registered company tax number.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}