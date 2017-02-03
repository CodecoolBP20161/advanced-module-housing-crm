package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "condominium")
public class Condominium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    // todo: complete with appropriate parameters
    @ManyToOne
    private Set<Company> ownerCompany;
    // todo: as well...manager?????

    private Condominium() {
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

    public Set<Company> getOwnerCompany() {
        return ownerCompany;
    }

    public void setOwnerCompany(Set<Company> ownerCompany) {
        this.ownerCompany = ownerCompany;
    }
}
