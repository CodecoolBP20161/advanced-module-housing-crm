package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by balag3 on 2017.02.17..
 */
@Data
@Entity
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String country;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    public Address() {
    }
}
