package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.CompanyUser;

import java.util.List;

/**
 * Created by balag3 on 2017.02.04..
 */
public interface CompanyUserQueryRepository {
    List<CompanyUser> selectAll();
}
