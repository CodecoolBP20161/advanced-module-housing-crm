package com.codecool.hccrm.dto;


import lombok.Data;


/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
public class CondominiumDTO extends AddressDTO {

    private String name;

    private String topographicalNumber;

    private int parcelNumber;

    private String contractingDate;

    private String generalMeetingDate;

}

