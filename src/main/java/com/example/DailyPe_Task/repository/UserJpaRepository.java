package com.example.DailyPe_Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DailyPe_Task.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
