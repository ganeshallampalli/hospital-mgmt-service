package com.hospital.project.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userId", "email"})
        })
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private Long mobileNo;
    private ERole role;
    private Date availableStartTiming;
    private Date availableEndTime;

    public User() {
    }

    public User(Long id, String userId, String name, String email, String password, String address, Long mobileNo, ERole role, Date availableStartTiming, Date availableEndTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobileNo = mobileNo;
        this.role = role;
        this.availableStartTiming = availableStartTiming;
        this.availableEndTime = availableEndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailId(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Date getAvailableStartTiming() {
        return availableStartTiming;
    }

    public void setAvailableStartTiming(Date availableStartTiming) {
        this.availableStartTiming = availableStartTiming;
    }

    public Date getAvailableEndTime() {
        return availableEndTime;
    }

    public void setAvailableEndTime(Date availableEndTime) {
        this.availableEndTime = availableEndTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                ", role=" + role +
                ", availableStartTiming=" + availableStartTiming +
                ", availableEndTime=" + availableEndTime +
                '}';
    }
}



















