package com.rijai.users.controller;


import com.rijai.users.model.User;
import com.rijai.users.repositry.UsersRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    UsersRepository usersRepository;


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        List<User> users = usersRepository.findAll();

        for (User u : users) {
            if (u.equals(users)) {
                return user.getEmail();
            }
        }
        return "Failed";
    }
}
