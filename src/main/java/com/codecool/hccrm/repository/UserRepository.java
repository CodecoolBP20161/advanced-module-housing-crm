package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
