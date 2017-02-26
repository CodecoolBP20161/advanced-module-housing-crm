package com.codecool.hccrm.model;

import com.codecool.hccrm.service.DateService;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by dorasztanko on 2017.02.18..
 * Last edited by dorasztanko on 2017.02.22..
 */
@Getter
@Setter
@MappedSuperclass
abstract class AbstractEntity {


    @Transient
    private DateService dateService() {
        return new DateService();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String createDate = dateService().currentDate();
}
