package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
    User findByEmailAndVerifiedTrue(String email);
}
