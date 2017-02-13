//package com.codecool.hccrm.controller;
//
//import com.codecool.hccrm.dto.CompanyDTO;
//import com.codecool.hccrm.event.OnRegistrationCompleteEvent;
//import com.codecool.hccrm.model.Company;
//import com.codecool.hccrm.model.User;
//import com.codecool.hccrm.service.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * Created by dorasztanko on 2017.02.09..
// */
//@Controller
//public class CompanyRegistrationController {
//
//    @Autowired
//    CompanyService companyService;
//
//    @Autowired
//    ApplicationEventPublisher eventPublisher;
//
//    @RequestMapping(value = "/user/registration_company", method = RequestMethod.GET)
//    public String renderRegisterCompanyForm(Model model) {
//        CompanyDTO company = new CompanyDTO();
//        model.addAttribute("company", company);
//        return "register_company";
//    }
//
//    @RequestMapping(value = "/company/register", method = RequestMethod.POST)
//    public ModelAndView submitNewCompany(
//            @ModelAttribute("company") CompanyDTO companyDTO,
//            BindingResult result,
//            WebRequest request,
//            Errors errors,
//            ModelMap modelMap) {
//
////        Company registered = createFromDTO(companyDTO, result);
//
//        return new ModelAndView("companyView", "company", company);
//
//    }
//
//    private Company createFromDTO(CompanyDTO companyDTO) {
//        return companyService.createNewCompany(companyDTO);
//    }
//}
