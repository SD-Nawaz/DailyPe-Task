package com.example.DailyPe_Task.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.DailyPe_Task.model.User;
import com.example.DailyPe_Task.service.UserH2Service;
import com.example.DailyPe_Task.service.UserJpaService;
import com.example.DailyPe_Task.service.UserService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserController {

    @Autowired
    public UserJpaService userService;

    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

}
