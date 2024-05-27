package com.example.DailyPe_Task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DailyPe_Task.model.User;
import com.example.DailyPe_Task.repository.UserJpaRepository;
import com.example.DailyPe_Task.repository.UserRepository;

@Service
public class UserJpaService implements UserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public ArrayList<User> getUsers() {
        List<User> userList = userJpaRepository.findAll();
        ArrayList<User> users = new ArrayList<>(userList);
        return users;
    }

    @Override
    public User getUserById(int userId) {
        try {
            User user = userJpaRepository.findById(userId).get();
            return user;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public User addUser(User user) {
        userJpaRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(int userId, User user) {
        try {
            User newUser = userJpaRepository.findById(userId).get();
            if (user.getManagerId() != null) {
                newUser.setManagerId(user.getManagerId());
            }
            if (user.getFullName() != null) {
                newUser.setFullName(user.getFullName());
            }
            if (user.getMobileNo() != null) {
                newUser.setMobileNo(user.getMobileNo());
            }
            if (user.getPanNo() != null) {
                newUser.setPanNo(user.getPanNo());
            }
            userJpaRepository.save(newUser);
            return newUser;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            userJpaRepository.deleteById(userId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
