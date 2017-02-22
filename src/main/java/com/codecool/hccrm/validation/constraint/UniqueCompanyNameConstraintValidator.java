package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.validation.UniqueCompanyName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dorasztanko on 2017.02.20..
 */
public class UniqueCompanyNameConstraintValidator implements ConstraintValidator<UniqueCompanyName, String> {

    @Autowired
    CompanyService companyService;

    public void initialize(UniqueCompanyName constraint) {
    }

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext constraintValidatorContext) {
        return notRegisteredCompanyByName(companyName);
    }

    private boolean notRegisteredCompanyByName(String companyName) {
        return companyService.findByCompanyName(companyName) == null;
    }
}
