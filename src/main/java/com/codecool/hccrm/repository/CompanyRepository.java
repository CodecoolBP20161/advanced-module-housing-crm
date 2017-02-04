package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String name);
}
