package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Date;

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
    private Date contractingDate;
    @Column
    private Date generalMeetingResolutionDate;
    @Column
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "companyUser_id")
    private CompanyUser managerUser;

    public Condominium() {
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

    public Date getContractingDate() {
        return contractingDate;
    }

    public void setContractingDate(Date contractingDate) {
        this.contractingDate = contractingDate;
    }

    public Date getGeneralMeetingResolutionDate() {
        return generalMeetingResolutionDate;
    }

    public void setGeneralMeetingResolutionDate(Date generalMeetingResolutionDate) {
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyUser getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(CompanyUser managerUser) {
        this.managerUser = managerUser;
    }
}
