package com.CourseScheduleBuilder.Services;

import com.CourseScheduleBuilder.Model.User;
import com.CourseScheduleBuilder.Repositories.RoleRepo;
import com.CourseScheduleBuilder.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userRepo.save(user);
    }



    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }






}
