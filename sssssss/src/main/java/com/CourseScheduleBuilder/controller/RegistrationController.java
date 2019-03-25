//package com.CourseScheduleBuilder.controller;
//
//
//import com.CourseScheduleBuilder.Model.User;
//import com.CourseScheduleBuilder.Services.RegistrationService;
//import com.CourseScheduleBuilder.Services.SecurityService;
//import com.CourseScheduleBuilder.Services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
///**
// */
//@RestController
//public class RegistrationController {
//
//    @Autowired
//    private RegistrationService registrationService;
//    private SecurityService securityService;
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/registration")
//    @CrossOrigin
//    @ResponseBody
//    public boolean validateAndRegisterNewUserRequest(@RequestBody User user, BindingResult bindingResult){
//        if (bindingResult.hasErrors()) {
//            return false;
//        }
//
//        userService.save(user);
//
//        //securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());  //Great for later to automatically login the user
//        System.out.println("New user:");
//        System.out.println("First name: "+user.getFirstName());
//        System.out.println("Last name: "+user.getLastName());
//        System.out.println("Username: "+user.getUsername());
//
//        return true;
//
//
//
//
//        //
//        // Verification of login info against database to be added.
//        // Checks include if username already exists in database.
//        // true boolean returned if registration successfully completed
//        // false boolean if registration failure (username already exists)
//        // FE should declare error if communication failure
//        // Prints message to console if duplicated attempted
//        // Repository find method returns a null value if the search returns no result
//        //
//
//
//    }
//}
//
