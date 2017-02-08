package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
