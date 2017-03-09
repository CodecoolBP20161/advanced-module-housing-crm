package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.repository.UserRepository;
import com.codecool.hccrm.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codecool.hccrm.model.RoleEnum.ROLE_CEO;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class UserService {

    @Autowired
    RoleService roleService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    public void save(User user) {
        userRepository.save(user);
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

    public User getUser(String verificationToken) {
        return tokenRepository.findByToken(verificationToken).getUser();
    }

    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Transactional
    public User createNewUser(SignUpDTO dto) {
        User newUser = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()), dto.getPhoneNumber());
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(ROLE_CEO.getRole()));
        newUser.setRoles(roles);
        save(newUser);
        return newUser;
    }

    public boolean currentUserOwnsCompany(Principal currentUser, String companyId) {
        Company company = companyService.findById(new Long(companyId));
        return (company.getCeoUsers().contains(findFirstByEmail(currentUser.getName())));
    }
}