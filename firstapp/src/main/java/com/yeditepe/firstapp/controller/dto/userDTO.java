package com.yeditepe.firstapp.controller.dto;

public class userDTO {


    public userDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    String username;
    String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
}
