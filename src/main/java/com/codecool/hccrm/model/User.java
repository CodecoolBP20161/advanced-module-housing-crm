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
@Table(name = "`user`")
@AttributeOverride(name="createDate", column = @Column(name="reg_date"))
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private Boolean verified;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(mappedBy = "ceoUsers")
    private Set<Company> companyCeos;

    @ManyToMany(mappedBy = "managerUsers")
    private Set<Company> companyManagers;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.verified = false;
    }
}
