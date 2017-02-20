package com.codecool.hccrm.validation.constraint;

import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.validation.UnReservedCompanyTaxNumber;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dorasztanko on 2017.02.20..
 */
public class UnReservedCompanyTaxNumberConstraintValidator implements ConstraintValidator<UnReservedCompanyTaxNumber, String> {

    @Autowired
    CompanyService companyService;

    @Override
    public void initialize(UnReservedCompanyTaxNumber unReservedCompanyTaxNumber) {

    }

    @Override
    public boolean isValid(String taxNumber, ConstraintValidatorContext constraintValidatorContext) {
        return notRegisteredCompanyByTaxNum(taxNumber);
    }

    private boolean notRegisteredCompanyByTaxNum(String taxNumber) {
        return companyService.findByTaxNumber(taxNumber) == null;
    }
}
