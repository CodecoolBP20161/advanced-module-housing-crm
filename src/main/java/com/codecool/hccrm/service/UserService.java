package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.UserDTO;
import com.codecool.hccrm.error.EmailAlreadyExistsException;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.repository.UserRepository;
import com.codecool.hccrm.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findFirstByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User findByEmailAndVerifiedTrue(String email) {
        return userRepository.findByEmailAndVerifiedTrue(email);
    }

    @Transactional
    public User createNewUser(UserDTO dto) throws EmailAlreadyExistsException {
        if (alreadyExists(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Already have user with " + dto.getEmail());
        }
        User user = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()), dto.getPhoneNumber());
        return userRepository.save(user);
    }

    private boolean alreadyExists(String email) {
        User user = findFirstByEmail(email);
        return user != null;
    }

    public User getUser(String verificationToken) {
        return tokenRepository.findByToken(verificationToken).getUser();
    }

    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    public void createVerificationToken(String token) {
        VerificationToken myToken = new VerificationToken(token);
        tokenRepository.save(myToken);
    }
}
