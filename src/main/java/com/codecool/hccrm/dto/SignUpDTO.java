package com.codecool.hccrm.dto;

import com.codecool.hccrm.validation.PasswordMatches;
import com.codecool.hccrm.validation.ValidEmail;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
@PasswordMatches
public class SignUpDTO {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String companyName;

    @NotNull
    @NotEmpty
    private String premise;

    @NotNull
    @NotEmpty
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
