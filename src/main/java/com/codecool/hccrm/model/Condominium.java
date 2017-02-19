package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by dorasztanko on 2017.02.02..
 * Last edited by dorasztanko on 2017.02.18..
 */
@Data
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

    public Condominium(Address address, String topographicalNumber, Integer parcelNumber, Calendar contractingDate, Calendar generalMeetingResolutionDate) {
        this.address = address;
        this.topographicalNumber = topographicalNumber;
        this.parcelNumber = parcelNumber;
        this.contractingDate = contractingDate;
        this.generalMeetingResolutionDate = generalMeetingResolutionDate;
    }
}
