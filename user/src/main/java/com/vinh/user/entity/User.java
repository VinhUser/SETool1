package com.vinh.user.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "is_leader")
    private Byte isLeader;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Byte status;

    public User() {

    }

    public User(Integer id, String username, String password, String role, Byte isLeader, Integer phone, String email, Byte status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isLeader = isLeader;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Byte getIsLeader() {
        return this.isLeader;
    }

    public void setIsLeader(Byte isLeader) {
        this.isLeader = isLeader;
    }

    public Integer getPhone() {
        return this.phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
