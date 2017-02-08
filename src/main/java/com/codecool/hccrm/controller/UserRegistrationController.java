package com.codecool.hccrm.controller;

import com.codecool.hccrm.dto.UserDTO;
import com.codecool.hccrm.error.EmailAlreadyExistsException;
import com.codecool.hccrm.event.OnRegistrationCompleteEvent;
import com.codecool.hccrm.model.User;
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

    /**
     * just a very basic registration form using Thymeleaf (and some magic)
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showBasicForm(WebRequest request, Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);//bind to model (magic)
        return "register";
    }

    /**
     * NOTES:
     * we need model to pass on to the view later the e-mail address
     * we need the request for later security stuff, like check for secure connection, etc
     * BindingResult is for easy validation http://codetutr.com/2013/05/28/spring-mvc-form-validation/
     * check for existing e-mail can only be done during the transaction to save user!!!
     *
     * @param userDTO
     * @param result
     * @param request
     * @param errors
     * @param model
     * @return
     */

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView submit(
                        @Valid @ModelAttribute("user") UserDTO userDTO,
                        BindingResult result,
                        WebRequest request,
                        Errors errors,
                        ModelMap model) {


        if (!result.hasErrors()) {

        }
        if (result.hasErrors()) {
            return new ModelAndView("register", "user", userDTO);
        }

        User registered = createFromDTO(userDTO, result);
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }

        try {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
        } catch (Exception me) {
            return new ModelAndView("emailError", "user", userDTO);
        }

        return new ModelAndView("userView", "user", userDTO);
    }

    private User createFromDTO(UserDTO userDTO, BindingResult result) {
        User user;
        try {
            user = userService.createNewUser(userDTO);
        } catch (EmailAlreadyExistsException e) {
            return null;
        }
        return user;
    }
}
