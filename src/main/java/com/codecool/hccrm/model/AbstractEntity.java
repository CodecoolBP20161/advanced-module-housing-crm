package com.codecool.hccrm.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dorasztanko on 2017.02.18..
 */
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar createDate = Calendar.getInstance(Locale.GERMANY);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }
}
