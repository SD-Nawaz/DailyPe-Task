package com.example.DailyPe_Task.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.DailyPe_Task.model.User;

@Repository
public interface UserRepository {
    ArrayList<User> getUsers();

    User getUserById(int userId);

    User addUser(User user);

    User updateUser(int userId, User user);

    void deleteUser(int userId);
}
