package com.codecool.hccrm.model;

import com.codecool.hccrm.service.DateService;

import javax.persistence.*;

/**
 * Created by dorasztanko on 2017.02.18..
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
