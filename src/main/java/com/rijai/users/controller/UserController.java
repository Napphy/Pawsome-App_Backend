package com.rijai.users.controller;


import com.rijai.users.model.User;
import com.rijai.users.repositry.UsersRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UsersRepository usersRepository;


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        LoggerFactory.getLogger(getClass()).info("usersRepository: {}", usersRepository); // Log before line 22
        User existingUser = usersRepository.findByEmail(user.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return user.getEmail(); // Or return a more meaningful response
        }
        return "Failed";
    }

}
