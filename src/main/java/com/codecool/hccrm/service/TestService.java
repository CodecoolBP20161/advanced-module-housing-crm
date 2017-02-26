package com.codecool.hccrm.service;

import com.codecool.hccrm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static com.codecool.hccrm.model.RoleEnum.ROLE_CEO;

/**
 * Created by balag3 on 2017.02.03..
 * Last edited by dorasztanko on 2017.02.26..
 */
@Service
public class TestService {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    CondominiumService condominiumService;

    @Autowired
    AddressService addressService;

    @Autowired
    RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void testClient() {
        //
        // user1
        User user1 = new User("Karen", "Pettigrew", "hccrm.robotkutya+1@gmail.com", passwordEncoder.encode("codecool"), "0036301234568");
        user1.setVerified(true);

        // set user1 role
        Set<Role> role = new HashSet<>();
        role.add(roleService.findByName(ROLE_CEO.getRole()));
        user1.setRoles(role);
        userService.save(user1);

        // save static addresses
        Address address1 = new Address("Hungary", "6547", "Karancslapujtő", "87 Sylvan Ave", null);
        Address address4 = new Address("Belgium", "65168", "Bruges", "823 Fishers Ln", null);
        Address address5 = new Address("Germany", "654715", "Leipzig",  "4 Brookcrest Dr #7786", null);
        Address address6 = new Address("U.S.A.", "659947", "Los Angeles", "4129 Abbott Dr", null);
        Address address7 = new Address("Hungary", "654337", "Kiskunhalas", "72 Wyoming Ave", null);
        addressService.save(address1);
        addressService.save(address4);
        addressService.save(address5);
        addressService.save(address6);
        addressService.save(address7);

        // add company and connect user to company as ceo
        Company company1 = new Company("Landrum Temporary Services", "1234567892", "Inverlaw");
        company1.setAddress(address1);
        Set<User> ceos = new HashSet<>();
        ceos.add(user1);
        company1.setCeoUsers(ceos);
        companyService.save(company1);

        // add condominiums
        Condominium condominium1 = new Condominium("255165", 123456,  GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium1.setAddress(address1);
        condominium1.setCompany(company1);
        Condominium condominium4 = new Condominium("336515", 351516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium4.setAddress(address4);
        condominium4.setCompany(company1);
        Condominium condominium5 = new Condominium("336535115", 451516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium5.setAddress(address5);
        condominium5.setCompany(company1);
        Condominium condominium6 = new Condominium("336511115", 551516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium6.setAddress(address6);
        condominium6.setCompany(company1);
        Condominium condominium7 = new Condominium("00336515", 751516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium7.setAddress(address7);
        condominium7.setCompany(company1);
        condominiumService.save(condominium1);
        condominiumService.save(condominium4);
        condominiumService.save(condominium5);
        condominiumService.save(condominium6);
        condominiumService.save(condominium7);

        //
        // user2
        User user2 = new User("John", "Smith", "hccrm.robotkutya+2@gmail.com", passwordEncoder.encode("codecool"), "0036301234567");
        user2.setVerified(true);

        Set<Role> role2 = new HashSet<>();
        role2.add(roleService.findByName(ROLE_CEO.getRole()));
        user2.setRoles(role2);
        userService.save(user2);

        Address address2 = new Address("United Kingdom", "654684-RA", "London", "43157 Cypress St", "Door 8.");
        addressService.save(address2);

        Company company2 = new Company("Morris Downing & Sherred", "1234567893", "Burpengary");
        company2.setAddress(address2);
        Set<User> ceos2 = new HashSet<>();
        ceos2.add(user2);
        company2.setCeoUsers(ceos2);
        companyService.save(company2);

        Company company6 = new Company("Angelo International", "1234567896", "New York");
        company6.setAddress(address4);
        Set<User> ceos3 = new HashSet<>();
        ceos3.add(user2);
        company6.setCeoUsers(ceos3);
        companyService.save(company6);

        Condominium condominium2 = new Condominium("255165", 123456,  GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        condominium2.setAddress(address2);
        condominium2.setCompany(company2);
        condominiumService.save(condominium2);


        //
        // user3
        User user3 = new User("Camellia", "Bourbonnais", "hccrm.robotkutya+3@gmail.com", passwordEncoder.encode("codecool"), "0036301234510");
        user3.setVerified(true);

        Set<Role> role3 = new HashSet<>();
        role3.add(roleService.findByName(ROLE_CEO.getRole()));
        user3.setRoles(role3);
        userService.save(user3);

        Company company4 = new Company("Vincent J Petti & Co", "1234567894", "New York");
        company4.setAddress(address7);
        Set<User> ceos4 = new HashSet<>();
        ceos4.add(user3);
        company4.setCeoUsers(ceos4);
        companyService.save(company4);

        Company company7 = new Company("Gateway Refrigeration", "1234567897", "New York");
        company7.setAddress(address5);
        Set<User> ceos5 = new HashSet<>();
        ceos5.add(user3);
        company7.setCeoUsers(ceos5);
        companyService.save(company7);
    }
}