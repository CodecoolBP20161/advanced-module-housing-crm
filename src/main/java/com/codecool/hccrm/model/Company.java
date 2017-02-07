package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, unique = true)
    private String companyName;

    @Column(nullable = true, unique = true)
    private String taxNumber;

    @Column(nullable = true, unique = true)
    private String premise;



    @Column
    private Date regDate;

    @ManyToMany
    @JoinTable(name = "company_ceoUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> ceoUsers;

    @ManyToMany
    @JoinTable(name = "company_managerUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> managerUsers;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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
