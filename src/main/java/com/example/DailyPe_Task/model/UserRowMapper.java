package com.example.DailyPe_Task.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("managerId"), rs.getString("fullName"), rs.getString("mobileNo"),
                rs.getString("panNo"));
    }

}
