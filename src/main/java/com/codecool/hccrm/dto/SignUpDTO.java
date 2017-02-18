package com.codecool.hccrm.dto;

//import com.codecool.hccrm.validation.PasswordChecked;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
//@PasswordChecked
public class SignUpDTO {

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
}
