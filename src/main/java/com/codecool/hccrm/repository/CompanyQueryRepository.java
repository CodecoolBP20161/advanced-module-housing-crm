package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by balag3 on 2017.02.04..
 */

@Repository
public interface CompanyQueryRepository {
    List<Condominium> getCondominiums(Company company);

    List<Company> selectAll();
}
