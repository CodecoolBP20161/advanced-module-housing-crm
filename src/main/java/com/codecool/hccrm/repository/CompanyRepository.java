package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String name);

    Company findByPremiseAndTaxNumber(String premise, String taxNumber);
}
