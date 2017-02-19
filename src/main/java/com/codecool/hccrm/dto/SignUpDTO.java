package com.codecool.hccrm.dto;

import com.codecool.hccrm.validation.PasswordMatches;
import com.codecool.hccrm.validation.Phone;
import com.codecool.hccrm.validation.ValidEmail;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
@PasswordMatches
public class SignUpDTO {

    @Size(min=2, max=30)
    private String firstName;

    @Size(min=2, max=30)
    private String lastName;

    @ValidEmail
    private String email;

    @Phone
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    private String password;

    @NotNull
    @NotEmpty
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
