package com.codecool.hccrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by dorasztanko on 2017.02.02..
 * Last edited by dorasztanko on 2017.02.22..
 */
@Getter
@Setter
@Entity
@Table(name = "condominium")
public class Condominium extends AbstractEntity {

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User managerUser;

    public Condominium() {
    }

    public Condominium(String topographicalNumber, Integer parcelNumber, Calendar contractingDate, Calendar generalMeetingResolutionDate) {
        this.topographicalNumber = topographicalNumber;
        this.parcelNumber = parcelNumber;
        this.contractingDate = contractingDate;
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
    }
}
