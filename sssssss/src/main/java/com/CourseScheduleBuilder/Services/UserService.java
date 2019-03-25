package com.CourseScheduleBuilder.Services;
import com.CourseScheduleBuilder.Model.User;

public interface UserService {
        void save(User user);

        User findByUsername(String username);
}
