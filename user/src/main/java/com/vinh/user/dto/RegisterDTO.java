package com.vinh.user.dto;

public class RegisterDTO {
   private String username;
   private String email;
   private String password;
   private int phone;

    public RegisterDTO(String username, String email, String password, int phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public RegisterDTO() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
