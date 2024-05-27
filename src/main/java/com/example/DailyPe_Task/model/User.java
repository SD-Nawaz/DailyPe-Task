package com.example.DailyPe_Task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "managerid")
    private String managerId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "mobileno")
    private String mobileNo;

    @Column(name = "panno")
    private String PanNo;

    public User(int id, String managerId, String fullName, String mobileNo, String PanNo) {
        this.id = id;
        this.managerId = managerId;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.PanNo = PanNo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerId() {
        return this.managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPanNo() {
        return this.PanNo;
    }

    public void setPanNo(String PanNo) {
        this.PanNo = PanNo;
    }
}
