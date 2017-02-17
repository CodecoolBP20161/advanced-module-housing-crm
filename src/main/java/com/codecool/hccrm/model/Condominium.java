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

}
