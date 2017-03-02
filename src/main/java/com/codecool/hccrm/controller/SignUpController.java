package com.codecool.hccrm.controller;

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.event.OnRegistrationCompleteEvent;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.service.AddressService;
import com.codecool.hccrm.service.CompanyService;
import com.codecool.hccrm.service.UserService;
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

import static com.codecool.hccrm.logging.LogFormatter.FORMAT;

/**
 * Created by prezi on 2017. 02. 06..
 * Last edited by dorasztanko on 2017.02.18..
 */
@Controller
public class SignUpController {
    private Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    AddressService addressService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderSignUp(Model model) {
        logger.info(FORMAT.getFormatter() + "Sign up page is rendered.");

        SignUpDTO dto = new SignUpDTO();
        model.addAttribute("signupForm", dto);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String submit(
            @ModelAttribute("signupForm") @Valid SignUpDTO dto,
            BindingResult result,
            Model model,
            WebRequest request) {

        if (result.hasErrors()) {
            return "signup";
        }
        User registeredUser = userService.createNewUser(dto);
        Address registeredAddress = addressService.createNewAddress(dto);
        companyService.createNewCompany(dto, registeredUser, registeredAddress);
        // sending email
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registeredUser, request.getLocale(), request.getContextPath()));
        // redirecting to index page, successful registration pop up --- please, log in!
        model.addAttribute("user", registeredUser);
        return "index";
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
            return "verification_bad";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpirationDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return "verification_bad";
        }

        user.setVerified(true);
        userService.save(user);
        return "login_verified";
    }
}
