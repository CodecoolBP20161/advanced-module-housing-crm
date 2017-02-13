package com.codecool.hccrm.controller.user;

import com.codecool.hccrm.dto.CompanyDTO;
import com.codecool.hccrm.error.CompanyAlreadyExistsException;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.service.RoleService;
import com.codecool.hccrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dorasztanko on 2017.02.09..
 */
@Controller
public class CompanyRegistrationController {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/user/registration_company", method = RequestMethod.GET)
    public String renderRegisterCompanyForm(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());
        CompanyDTO company = new CompanyDTO();
        model.addAttribute("company", company);
        return "register_company";
    }

    @RequestMapping(value = "/user/registration_company", method = RequestMethod.POST)
    public ModelAndView submitNewCompany(
            @ModelAttribute("company") CompanyDTO companyDTO,
            BindingResult result,
            Errors errors,
            ModelMap modelMap,
            HttpServletRequest request) {

        // COMPANY
        Company registeredCompany = createFromDTO(companyDTO);
        if (registeredCompany == null) {
            return new ModelAndView("error_page");
        }

        // getting current user
        Principal principal = request.getUserPrincipal();
        // USER
        User currentUser = userService.findFirstByEmail(principal.getName());

        // setting ceo
        Set<User> ceos = new HashSet<>();
        ceos.add(currentUser);
        registeredCompany.setCeoUsers(ceos);

        // setting CEO role to User
        Role ceo = roleService.findByName("ROLE_CEO");
        Set<Role> roles = new HashSet<>();
        roles.add(ceo);
        currentUser.setRoles(roles);

        // saving to db
        companyService.save(registeredCompany);
        userService.save(currentUser);

        return new ModelAndView("companyView", "company", companyDTO);
    }

    private Company createFromDTO(CompanyDTO companyDTO) {
        Company company;
        try {
            company = companyService.createNewCompany(companyDTO);
        } catch (CompanyAlreadyExistsException e) {
            company = null;
        }
        return company;
    }
}
