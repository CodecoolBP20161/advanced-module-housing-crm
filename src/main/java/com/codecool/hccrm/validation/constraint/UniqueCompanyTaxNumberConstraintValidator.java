package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.validation.UniqueCompanyTaxNumber;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dorasztanko on 2017.02.20..
 */
public class UniqueCompanyTaxNumberConstraintValidator implements ConstraintValidator<UniqueCompanyTaxNumber, String> {

    @Autowired
    CompanyService companyService;

    @Override
    public void initialize(UniqueCompanyTaxNumber uniqueCompanyTaxNumber) {

    }

    @Override
    public boolean isValid(String taxNumber, ConstraintValidatorContext constraintValidatorContext) {
        return notRegisteredCompanyByTaxNum(taxNumber);
    }

    private boolean notRegisteredCompanyByTaxNum(String taxNumber) {
        return companyService.findByTaxNumber(taxNumber) == null;
    }
}
