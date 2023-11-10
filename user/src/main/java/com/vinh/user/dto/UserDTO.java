package com.vinh.user.dto;

public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private Byte isLeader;
    private Integer phone;
    private String email;
    private Byte status;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String password, String role, Byte isLeader, Integer phone, String email, Byte status) {
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
