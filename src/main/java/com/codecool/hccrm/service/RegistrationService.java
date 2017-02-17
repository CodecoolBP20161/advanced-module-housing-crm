package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.UserCompanyRegistrationDTO;
import com.codecool.hccrm.error.CompanyAlreadyExistsException;
import com.codecool.hccrm.error.EmailAlreadyExistsException;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by balag3 on 2017.02.17..
 */
@Service
public class RegistrationService {

    @Autowired
    AddressService addressService;

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    public void register(UserCompanyRegistrationDTO dto) throws CompanyAlreadyExistsException, EmailAlreadyExistsException {
        User user = userService.createNewUser(dto);
        Set<Role> roles = user.getRoles();
        roles.add(roleService.findByName("ROLE_CEO"));
        user.setRoles(roles);
        Company company = companyService.createNewCompany(dto);
        Set<User> ceos = company.getCeoUsers();
        ceos.add(user);
        company.setCeoUsers(ceos);
        Address address = addressService.createNewAddress(dto);
        company.setAddress(address);
        userService.save(user);
        companyService.save(company);
        addressService.save(address);
    }
}
