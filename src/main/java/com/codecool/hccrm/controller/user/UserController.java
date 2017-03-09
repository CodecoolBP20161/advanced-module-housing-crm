package com.codecool.hccrm.controller.user;

import com.codecool.hccrm.dto.CondominiumDTO;
import com.codecool.hccrm.dto.builder.CondominiumDTOBuilder;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.service.CondominiumService;
import com.codecool.hccrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

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
        return "user/user_dashboard";
    }

    @RequestMapping(value = {"/user/{company_id}/condominiums"}, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') or @userService.currentUserOwnsCompany(#currentUser, #companyId)")
    public String listCondominiums(@PathVariable("company_id") String companyId,  Model model, Principal currentUser) {
        Company company = companyService.findById(new Long(companyId));
        List<Condominium> condominiums = condominiumService.findByCompany(company);
        model.addAttribute("condominiums", condominiums);
        model.addAttribute("companyId", company.getId());
        CondominiumDTO dto = new CondominiumDTO();
        model.addAttribute("condominiumDTO", dto);
        return "user/user_dashboard";
    }

    @RequestMapping(value = {"user/{company_id}/condominiums/add"}, method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN') or @userService.currentUserOwnsCompany(#currentUser, #companyId)")
    public String addCondominium(@PathVariable("company_id") String companyId, @ModelAttribute CondominiumDTO dto, Principal currentUser) throws ParseException {
        Company company = companyService.findById(new Long(companyId));
        Condominium condominium = condominiumService.createFromDTO(dto);
        condominium.setCompany(company);
        condominiumService.save(condominium);
        return "redirect:/user/" + companyId + "/condominiums";
    }

    @RequestMapping(value = {"user/{company_id}/condominiums/{condominium_id}"}, method = RequestMethod.GET)
    public String displayCondominium(@PathVariable("company_id") String companyId, @PathVariable("condominium_id") String condomId, Principal currentUser, Model model) {
        Condominium condominium = condominiumService.findById(new Long(condomId));
        model.addAttribute("condominium", condominium);
        model.addAttribute("companyId", companyId);
        return "user/condominium_profile";
    }

    @RequestMapping(value = {"user/{company_id}/condominiums/{condominium_id}/edit"}, method = RequestMethod.GET)
    public String editCondominium(@PathVariable("company_id") String companyId, @PathVariable("condominium_id") String condomId, Principal currentUser, Model model) {
        Condominium condominium = condominiumService.findById(new Long(condomId));
        CondominiumDTOBuilder cb = new CondominiumDTOBuilder();
        CondominiumDTO condominiumDTO = cb.fromCondominium(condominium);
        model.addAttribute("condominiumDTO", condominiumDTO);
        return "user/condominium_profile";
    }
}
