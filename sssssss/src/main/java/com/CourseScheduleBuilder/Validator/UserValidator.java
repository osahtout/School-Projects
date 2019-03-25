package com.CourseScheduleBuilder.Validator;

import com.CourseScheduleBuilder.Model.User;
import com.CourseScheduleBuilder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> anotherClass)
    { return User.class.equals(anotherClass);}

    @Override
    public void validate(Object object, Errors errors)
    {
        User user  = (User) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Should not be Empty");
        if(user.getUsername().length() < 2 || user.getUsername().length() > 32)
            errors.rejectValue("username", "is not an email");

        if(userService.findByUsername(user.getUsername()) != null)
        errors.rejectValue("username", "email already exists");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Should not be Empty");
        if(user.getUsername().length() < 2 || user.getUsername().length() > 32 )
            errors.rejectValue("password", "size of password is not good");

        if(user.getPasswordConfirm().equals(user.getPassword()))
            errors.rejectValue("password Confirm", "passwords do not match");

    }

}
