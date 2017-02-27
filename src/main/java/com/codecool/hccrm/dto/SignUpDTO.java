package com.codecool.hccrm.dto;

import com.codecool.hccrm.validation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Getter
@Setter
@PasswordMatches
public class SignUpDTO {

    @ValidPersonName
    private String firstName;

    @ValidPersonName
    private String lastName;

    @ValidEmail
    @UniqueEmail
    private String email;

    @Phone
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    private String password;

    private String matchingPassword;

    @NotNull
    @NotEmpty
    @UniqueCompanyName
    private String companyName;

    @NotNull
    @NotEmpty
    private String premise;

    @NotNull
    @NotEmpty
    @UniqueCompanyTaxNumber
    private String taxNumber;

    @NotNull
    @NotEmpty
    private String country;

    @NotNull
    @NotEmpty
    private String zipCode;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String addressLine1;

    private String addressLine2;
}
