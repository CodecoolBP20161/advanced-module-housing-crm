package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by dorasztanko on 2017.02.02..
 * Last edited by dorasztanko on 2017.02.18..
 */
@Entity
@Table(name = "condominium")
public class Condominium extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private String topographicalNumber;

    @Column
    private Integer parcelNumber;

    @Column
    private Calendar contractingDate;

    @Column
    private Calendar generalMeetingResolutionDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User managerUser;

    public Condominium() {
    }

    public Condominium(Address address, String topographicalNumber, Integer parcelNumber, Calendar contractingDate, Calendar generalMeetingResolutionDate) {
        this.address = address;
        this.topographicalNumber = topographicalNumber;
        this.parcelNumber = parcelNumber;
        this.contractingDate = contractingDate;
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTopographicalNumber() {
        return topographicalNumber;
    }

    public void setTopographicalNumber(String topographicalNumber) {
        this.topographicalNumber = topographicalNumber;
    }

    public Integer getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(Integer parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public Calendar getContractingDate() {
        return contractingDate;
    }

    public void setContractingDate(Calendar contractingDate) {
        this.contractingDate = contractingDate;
    }

    public Calendar getGeneralMeetingResolutionDate() {
        return generalMeetingResolutionDate;
    }

    public void setGeneralMeetingResolutionDate(Calendar generalMeetingResolutionDate) {
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(User managerUser) {
        this.managerUser = managerUser;
    }
}
