package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dorasztanko on 2017.02.02..
 * Last edited by dorasztanko on 2017.02.18..
 */
@Data
@Entity
@Table(name = "company")
public class Company extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    @Column(nullable = false)
    private String premise;

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
}
