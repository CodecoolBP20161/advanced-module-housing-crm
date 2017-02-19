package com.codecool.hccrm.service;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by balag3 on 2017.02.09..
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

    VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    VerificationToken findByUser(User user) {
        return verificationTokenRepository.findByUser(user);
    }

    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token);
        myToken.setUser(user);
        save(myToken);
    }
}
