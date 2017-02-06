package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by prezi on 2017. 02. 06..
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

}
