package com.example.ims.controllers.beans;

import com.example.ims.entities.User;

public class LoginResponse {

    private User user;
    private String error;

    public LoginResponse(String error) {
        this.error = error;
    }

    public LoginResponse(User user) {
        this.user = user;
    }

}
