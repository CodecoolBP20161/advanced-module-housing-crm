package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "condominium")
public class Condominium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String address;

    @Column
    private String topographicalNumber;

    @Column
    private Integer parcelNumber;

    @Column
    private Calendar contractingDate;

    @Column
    private Calendar generalMeetingResolutionDate;

    @Column
    private Calendar regDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User managerUser;

    protected Condominium() {
    }

    public Condominium(String address, String topographicalNumber, Integer parcelNumber, Calendar contractingDate, Calendar generalMeetingResolutionDate) {
        this.address = address;
        this.topographicalNumber = topographicalNumber;
        this.parcelNumber = parcelNumber;
        this.contractingDate = contractingDate;
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
        this.regDate = Calendar.getInstance();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public Calendar getRegDate() {
        return regDate;
    }

    public void setRegDate(Calendar regDate) {
        this.regDate = regDate;
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
