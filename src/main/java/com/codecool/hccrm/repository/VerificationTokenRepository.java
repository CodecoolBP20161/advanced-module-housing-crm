package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prezi on 2017. 02. 06..
 */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
