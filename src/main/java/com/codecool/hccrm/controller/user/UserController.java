package com.codecool.hccrm.controller.user;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.service.CondominiumService;
import com.codecool.hccrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by dorasztanko on 2017.02.19..
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CondominiumService condominiumService;

    @RequestMapping(value = {"/user/dashboard"}, method = RequestMethod.GET)
    public String renderUserDashboard(Model model, Principal principal) {
        User currentUser = userService.findFirstByEmail(principal.getName());
        List<Company> companyList = companyService.findByCeoUsers(currentUser);
        model.addAttribute("company_list", companyList );
        return "user_dashboard";
    }

    @RequestMapping(value = {"/user/{company_id}/condominiums"}, method = RequestMethod.GET)
    public String listCondominiums(@PathVariable("company_id") String companyId,  Model model) {
        Company company = companyService.findById(new Long(companyId));
        List<Condominium> condominiums = condominiumService.findByCompany(company);
        model.addAttribute("condominiums", condominiums);
        return "user_dashboard";

    }
}
