package com.codecool.hccrm.dto;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Calendar;


/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
public class CondominiumDTO {

    private String name;

    private String topographicalNumber;

    private int parcelNumber;

    private Calendar contractingDate;

    private Calendar generalMeetingDate;

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

