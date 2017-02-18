package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by balag3 on 2017.02.17..
 * Last edited by dorasztanko on 2017.02.18..
 */
@Data
@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String addressLine1;

    @Column
    private String addressLine2;

    public Address() {
    }

    public Address(String country, String zipCode, String city, String addressLine1, String addressLine2) {
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }
}