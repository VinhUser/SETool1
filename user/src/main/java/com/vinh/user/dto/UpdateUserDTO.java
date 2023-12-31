package com.vinh.user.dto;

public class UpdateUserDTO {
    private String username;
    private String email;
    private Integer phone;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String username, String email, Integer phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
