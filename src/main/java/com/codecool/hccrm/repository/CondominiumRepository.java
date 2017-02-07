package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "condominium", path = "condominium")
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
    List<Condominium> findByCompany(Company c);
}
