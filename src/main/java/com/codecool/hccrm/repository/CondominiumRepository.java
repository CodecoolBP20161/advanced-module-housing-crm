package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
}
