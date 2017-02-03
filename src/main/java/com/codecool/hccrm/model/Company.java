package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String companyName;
    @Column(nullable = false, unique = true)
    private String taxNumber;
    @Column(nullable = false, unique = true)
    private String premise;
    @Column
    private Date regDate;
//    todo: complete with parameters!
    @OneToMany
    private Set<Condominium> condominiums;

    private Company() {
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

    public Set<Condominium> getCondominiums() {
        return condominiums;
    }

    public void setCondominiums(Set<Condominium> condominiums) {
        this.condominiums = condominiums;
    }
}
