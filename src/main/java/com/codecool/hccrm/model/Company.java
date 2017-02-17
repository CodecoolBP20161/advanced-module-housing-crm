package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    @Column(nullable = false)
    private String premise;

    @Column
    private Calendar regDate;

    @ManyToMany
    @JoinTable(name = "company_ceoUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> ceoUsers;

    @ManyToMany
    @JoinTable(name = "company_managerUsers", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "companyUser_id"))
    private Set<User> managerUsers;

    public Company() {
    }

}
