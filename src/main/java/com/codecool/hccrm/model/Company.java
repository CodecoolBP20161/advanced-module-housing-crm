package com.codecool.hccrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dorasztanko on 2017.02.02..
 * Last edited by dorasztanko on 2017.02.22..
 */
@Getter
@Setter
@Entity
@Table(name = "company")
@AttributeOverride(name="createDate", column = @Column(name="reg_date"))
public class Company extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    @Column(nullable = false)
    private String premise;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CompanyStatus companyStatus = CompanyStatus.PENDING;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "company_ceoUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> ceoUsers;

    @ManyToMany
    @JoinTable(name = "company_managerUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> managerUsers;

    public Company() {
    }

    public Company(String companyName, String taxNumber, String premise) {
        this.companyName = companyName;
        this.taxNumber = taxNumber;
        this.premise = premise;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<User> getCeoUsers() {
        return ceoUsers;
    }

    public void setCeoUsers(Set<User> ceoUsers) {
        this.ceoUsers = ceoUsers;
    }

    public Set<User> getManagerUsers() {
        return managerUsers;
    }

    public void setManagerUsers(Set<User> managerUsers) {
        this.managerUsers = managerUsers;
    }
}
