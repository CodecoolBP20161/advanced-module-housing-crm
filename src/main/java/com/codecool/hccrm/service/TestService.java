package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;

/**
 * Created by balag3 on 2017.02.03..
 * Last edited by dorasztanko on 2017.02.18..
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
    RoleService roleService;


    public void testClient() throws Exception {
        // generate companies
        Company company = new Company("Lex Corporation", "1234567890", "Hamel");
        Company company1 = new Company("Partition Ltd.", "1234567891", "Ringwood");
        Company company2 = new Company("Landrum Temporary Services", "1234567892", "Inverlaw");
        Company company3 = new Company("Morris Downing & Sherred", "1234567893", "Burpengary");
        Company company4 = new Company("Vincent J Petti & Co", "1234567894", "New York");
        Company company5 = new Company("Swanson Peterson Fnrl Home Inc", "1234567895", "Maylands");
        Company company6 = new Company("Angelo International", "1234567896", "New York");
        Company company7 = new Company("Gateway Refrigeration", "1234567897", "New York");
        Company company8 = new Company("Anchorage Yamaha", "1234567898", "Maylands");
        Company company9 = new Company("Kansas Association Ins Agtts", "1234567899", "Kennedy");
        Company company10 = new Company("Public Works Department", "1234567811", "New York");

        companyService.save(company);
        companyService.save(company1);
        companyService.save(company2);
        companyService.save(company3);
        companyService.save(company4);
        companyService.save(company5);
        companyService.save(company6);
        companyService.save(company7);
        companyService.save(company8);
        companyService.save(company9);
        companyService.save(company10);

        // generate condominiums
        Condominium condominium1 = new Condominium("87 Sylvan Ave", "331535", 255165, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium2 = new Condominium("8839 Ventura Blvd", "336515", 151516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium3 = new Condominium("43157 Cypress St", "336515", 221516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium4 = new Condominium("823 Fishers Ln", "336515", 351516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium5 = new Condominium("4 Brookcrest Dr #7786", "336515", 451516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium6 = new Condominium("4129 Abbott Dr", "336515", 551516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium7 = new Condominium("72 Wyoming Ave", "336515", 751516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium8 = new Condominium("71585 S Ayon Ave #9", "336515", 851516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium9 = new Condominium("7 Valley Blvd", "336515", 951516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium10 = new Condominium("8 S Plaza Dr", "336515", 101516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium11 = new Condominium("5 Shakespeare Ave", "336515", 111516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium12 = new Condominium("3175 Northwestern Hwy", "336515", 121516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium13 = new Condominium("8 Middletown Blvd #708", "336515", 131516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium14 = new Condominium("661 Plummer St #963", "336515", 141516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium15 = new Condominium("2391 Pacific Blvd", "336515", 151516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium16 = new Condominium("5656 N Fiesta Blvd", "336515", 161516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());

        // generate users
        User admin1 = new User("Condom", "JustAdmin", "hccrm.robotkutya+3@gmail.com", "115654", "+36301234569");
        User admin2 = new User("Condom", "AdminManager", "hccrm.robotkutya+12@gmail.com", "115633", "+36301234533");
        User admin3 = new User("Condom", "AdminCeo", "hccrm.robotkutya+13@gmail.com", "115634", "+36301234534");
        User user2 = new User("Karen", "Pettigrew", "hccrm.robotkutya+2@gmail.com", "1235", "+36301234568");
        User user3 = new User("John", "Smith", "hccrm.robotkutya+1@gmail.com", "1234", "+36301234567");
        User user4 = new User("Camellia", "Bourbonnais", "hccrm.robotkutya+4@gmail.com", "115655", "+36301234510");
        User user5 = new User("Rupert", "Stoneking", "hccrm.robotkutya+5@gmail.com", "115656", "+36301234511");
        User user6 = new User("Aleta", "Ellerbusch", "hccrm.robotkutya+6@gmail.com", "115657", "+36301234512");
        User user7 = new User("Jamal", "Julye", "hccrm.robotkutya+7@gmail.com", "115658", "+36301234513");
        User user8 = new User("Luz", "Majorga", "hccrm.robotkutya+8@gmail.com", "115659", "+36301234514");
        User user9 = new User("Janessa", "Oto", "hccrm.robotkutya+9@gmail.com", "115610", "+36301234515");
        User user10 = new User("Lavonne", "Geffers", "hccrm.robotkutya+10@gmail.com", "115611", "+36301234516");
        User user11 = new User("Ben", "Ploszaj", "hccrm.robotkutya+11@gmail.com", "115612", "+36301234517");
    }
}
