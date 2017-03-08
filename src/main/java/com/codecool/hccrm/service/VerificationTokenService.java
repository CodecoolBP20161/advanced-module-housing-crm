package com.codecool.hccrm.service;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by balag3 on 2017.02.09..30b2f44^..6c968df
 * Last edited by dorasztanko on 2017.03.02..
 */
@Service
public class VerificationTokenService {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);
    }

    public List<VerificationToken> findAll() {
        return verificationTokenRepository.findAll();
    }

    public void delete(VerificationToken token) {
        verificationTokenRepository.delete(token);
    }

    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    public VerificationToken findByUser(User user) {
        return verificationTokenRepository.findByUser(user);
    }

    public VerificationToken createVerificationToken(User user) {
        String randomToken = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(randomToken);
        verificationToken.setUser(user);
        save(verificationToken);
        return verificationToken;
    }
}
