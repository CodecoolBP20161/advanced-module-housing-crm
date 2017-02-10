package com.codecool.hccrm.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by dorasztanko on 2017.02.09..
 */
public class CompanyDTO {

    @NotNull
    @NotEmpty
    private String companyName;

    @NotNull
    @NotEmpty
    private String premise;

    @NotNull
    @NotEmpty
    private String taxNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
