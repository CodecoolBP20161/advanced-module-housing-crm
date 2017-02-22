package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String name);

    Company findByCompanyNameOrTaxNumber(String companyName, String taxNumber);

    Company findByTaxNumber(String taxNumber);

    List<Company> findByCeoUsers(User user);
}
