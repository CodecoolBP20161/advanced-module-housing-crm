package com.codecool.hccrm.controller;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.UserDTO;
import com.codecool.hccrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import javax.validation.Valid;

/**
 * Created by prezi on 2017. 02. 06..
 */

@Controller
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    // just a very basic registration form using Thymeleaf (and some magic)
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showBasicForm(WebRequest request, Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);//bind to model (magic)
        return "register";
    }

    // NOTES:
    // we need model to pass on to the view later the e-mail address
    // we need the request for later security stuff, like check for secure connection, etc
    // BindingResult is for easy validation http://codetutr.com/2013/05/28/spring-mvc-form-validation/
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String submit(
                        @Valid @ModelAttribute("user") UserDTO userDTO,
                        BindingResult result,
                        WebRequest request, Errors errors,
                        ModelMap model) {

        // do validation here for form input
        if (result.hasErrors()) {
            return "error";
        }

        // do validation for user in database, e.g. check if we already have e-mail then save, set role, etc
        // userService.createFromDTO(user);
        // you have to check for existing user while saving

        // send verification e-mail

        // pass on views depending on what happened
        model.addAttribute("id", userDTO.getId());
        model.addAttribute("email", userDTO.getEmail());
        model.addAttribute("password", userDTO.getPassword());
        return "userView";
    }

}
