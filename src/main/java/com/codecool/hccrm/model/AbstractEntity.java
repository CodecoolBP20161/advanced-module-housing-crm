package com.codecool.hccrm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@Data
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar createDate = Calendar.getInstance(Locale.GERMANY);
}
