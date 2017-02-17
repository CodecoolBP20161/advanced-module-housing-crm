package com.codecool.hccrm.controller;

import com.codecool.hccrm.dto.UserCompanyRegistrationDTO;
import com.codecool.hccrm.error.CompanyAlreadyExistsException;
import com.codecool.hccrm.error.EmailAlreadyExistsException;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by prezi on 2017. 02. 06..
 */

@Controller
public class UserRegistrationController {
    private Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RegistrationService registrationService;


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showBasicForm(WebRequest request, Model model) {
        UserCompanyRegistrationDTO usercompany = new UserCompanyRegistrationDTO();
        model.addAttribute("usercompany", usercompany);
        return "signup";
    }

    /**
     * NOTES:
     * we need model to pass on to the view later the e-mail address
     * we need the request for later security stuff, like check for secure connection, etc
     * BindingResult is for easy validation http://codetutr.com/2013/05/28/spring-mvc-form-validation/
     * check for existing e-mail can only be done during the transaction to save user!!!
     *
     * @param usercompany
     * @param result
     * @param request
     * @return
     */

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String submit(
            @Valid @ModelAttribute("usercompany") UserCompanyRegistrationDTO usercompany,
            BindingResult result,
            WebRequest request,
            Model model) {

        try {
            registrationService.register(usercompany);
        } catch (CompanyAlreadyExistsException e) {
            e.printStackTrace();
        } catch (EmailAlreadyExistsException e) {
            e.printStackTrace();
        }


//        try {
//
//            String appUrl = request.getContextPath();
//            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
//        } catch (Exception me) {
//            return new ModelAndView("emailError", "user", usercompany);
//        }

        return "user_dashboard";
    }

    private User createUserFromDTO(UserCompanyRegistrationDTO usercompany, BindingResult result) {
        User user;
        try {
            user = userService.createNewUser(usercompany);
        } catch (EmailAlreadyExistsException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    private Company createCompanyFromDTO(UserCompanyRegistrationDTO usercompany, BindingResult result) {
        Company company;
        try {
            company = companyService.createNewCompany(usercompany);

        } catch (CompanyAlreadyExistsException e) {
            e.printStackTrace();
            return null;
        }
        return company;
    }

    private Address createAddressFromDTO(UserCompanyRegistrationDTO usercompany, BindingResult result) {
        return addressService.createNewAddress(usercompany);
    }

    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) {

        // We need this for messages to work
        Locale locale = request.getLocale();

        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/badUser.html";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpirationDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return "redirect:/badUser.html";
        }

        user.setVerified(true);
        userService.save(user);
        return "redirect:/login.html";
    }
}
