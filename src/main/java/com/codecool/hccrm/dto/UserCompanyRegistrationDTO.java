package com.codecool.hccrm.dto;

import com.codecool.hccrm.validation.PasswordChecked;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by prezi on 2017. 02. 07..
 */
@Data
@PasswordChecked
public class UserCompanyRegistrationDTO {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String password;
    private String passwordCheck;

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
