package com.CourseScheduleBuilder.controller;

import com.CourseScheduleBuilder.Model.User;
import com.CourseScheduleBuilder.Model.UserFromFrontEnd;
import com.CourseScheduleBuilder.Services.SecurityService;
import com.CourseScheduleBuilder.Services.UserService;
import com.CourseScheduleBuilder.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    private SecurityService securityService;

    private UserValidator userValidator;

    @PostMapping("/registration")
    @CrossOrigin
    @ResponseBody
    public boolean registration(Model model) {
        model.addAttribute("userForm", new User());

        return true;
    }

    @PostMapping("/registration")
    @CrossOrigin
    @ResponseBody
    public boolean registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return false;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return true;
    }

    @GetMapping("/login")
    @CrossOrigin
    @ResponseBody
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

//    @GetMapping({"/", "/welcome"})
//    public String welcome(Model model) {
//        return "welcome";
//    }
}
