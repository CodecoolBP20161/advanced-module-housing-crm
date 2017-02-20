package com.codecool.hccrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by balag3 on 2017.02.17..
 * Last edited by dorasztanko on 2017.02.18..
 */
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}