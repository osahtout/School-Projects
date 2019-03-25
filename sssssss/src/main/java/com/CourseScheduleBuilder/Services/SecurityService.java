package com.CourseScheduleBuilder.Services;

public interface SecurityService {

    String findLoggedInUsername(); //which is the email
    void autoLogin(String username, String password);
}
