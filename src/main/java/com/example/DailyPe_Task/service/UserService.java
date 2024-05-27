package com.example.DailyPe_Task.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DailyPe_Task.model.User;
import com.example.DailyPe_Task.repository.UserRepository;

@Service
public class UserService implements UserRepository {
    private HashMap<Integer, User> hmap = new HashMap<>();
    int uniqueId = 3;

    public UserService() {
        User u1 = new User(1, null, "Sayed Nawaz", "9876543210", "ABC12D5");
        User u2 = new User(2, null, "Rahul Attuluri", "6543210987", "XYZ45P6");

        hmap.put(u1.getId(), u1);
        hmap.put(u2.getId(), u2);
    }

    @Override
    public ArrayList<User> getUsers() {
        Collection<User> userCollection = hmap.values();
        ArrayList<User> users = new ArrayList<>(userCollection);
        return users;
    }

    @Override
    public User getUserById(int userId) {
        User user = hmap.get(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        user.setId(uniqueId);
        hmap.put(uniqueId, user);
        uniqueId += 1;
        return user;
    }

    @Override
    public User updateUser(int userId, User user) {
        User existingUser = hmap.get(userId);
        if (existingUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (user.getFullName() != null) {
            existingUser.setFullName(user.getFullName());
        }
        if (user.getManagerId() != null) {
            existingUser.setManagerId(user.getManagerId());
        }
        if (user.getMobileNo() != null) {
            existingUser.setMobileNo(user.getMobileNo());
        }
        if (user.getPanNo() != null) {
            existingUser.setPanNo(user.getPanNo());
        }
        return existingUser;
    }

    @Override
    public void deleteUser(int userId) {
        User existingUser = hmap.get(userId);
        if (existingUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            hmap.remove(userId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
