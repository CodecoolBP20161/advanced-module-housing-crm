package com.codecool.hccrm.controller;

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

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView showBasicForm() {
        return new ModelAndView("register", "user", new User());
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String submit(
                        @Valid @ModelAttribute("user") User user,
                        BindingResult result,
                        ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        userService.save(user);
        model.addAttribute("id", user.getId());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        return "userView";
    }

}
