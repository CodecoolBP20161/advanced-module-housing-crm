package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by balag3 on 2017.02.03..
 */
@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, Long>{
}
