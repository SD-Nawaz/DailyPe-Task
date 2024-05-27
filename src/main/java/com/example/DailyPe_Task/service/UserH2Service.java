package com.example.DailyPe_Task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DailyPe_Task.model.User;
import com.example.DailyPe_Task.model.UserRowMapper;
import com.example.DailyPe_Task.repository.UserRepository;

@Service
public class UserH2Service implements UserRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<User> getUsers() {
        List<User> userList = db.query("select * from users", new UserRowMapper());
        ArrayList<User> users = new ArrayList<>(userList);
        return users;
    }

    @Override
    public User getUserById(int userId) {
        try {
            User user = db.queryForObject("select * from users where id = ?", new UserRowMapper(), userId);
            return user;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User addUser(User user) {
        db.update("insert into users(managerId, fullName, mobileNo, panNo) values(?, ?, ?, ?)", user.getManagerId(),
                user.getFullName(), user.getMobileNo(), user.getPanNo());
        User savedUser = db.queryForObject(
                "select * from users where managerId = ? and fullName = ? and mobileNo = ? and panNo = ?",
                new UserRowMapper(),
                user.getManagerId(), user.getFullName(), user.getMobileNo(), user.getPanNo());
        return savedUser;
    }

    @Override
    public User updateUser(int userId, User user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (user.getManagerId() != null) {
            db.update("update users set managerId = ? where id = ?", user.getManagerId(), userId);
        }
        if (user.getFullName() != null) {
            db.update("update users set fullName = ? where id = ?", user.getFullName(), userId);
        }
        if (user.getMobileNo() != null) {
            db.update("update users set mobileNo = ? where id = ?", user.getMobileNo(), userId);
        }
        if (user.getPanNo() != null) {
            db.update("update users set panNo = ? where id = ?", user.getPanNo(), userId);
        }
        return getUserById(userId);
    }

    @Override
    public void deleteUser(int userId) {
        db.update("delete from users where id = ?", userId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
