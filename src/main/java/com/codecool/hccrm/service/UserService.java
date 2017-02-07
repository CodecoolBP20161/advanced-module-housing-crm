package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.UserDTO;
import com.codecool.hccrm.error.EmailAlreadyExistsException;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User createNewUser(UserDTO dto) throws EmailAlreadyExistsException {
        if (alreadyExists(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Already have user with " + dto.getEmail());
        }
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }

    private boolean alreadyExists(String email){
        User user = userRepository.findFirstByEmail(email);
        if (user == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
