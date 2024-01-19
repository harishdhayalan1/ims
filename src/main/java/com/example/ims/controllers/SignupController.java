package com.example.ims.controllers;

import com.example.ims.controllers.beans.SignupParameters;
import com.example.ims.repositories.UserRepository;
import com.example.ims.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;

public class SignupController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupParameters signupParams) {
        if(!signupParams.password.equals(signupParams.passwordConfirmation)) {
            return ResponseEntity.badRequest().body(Arrays.asList("Password Mismatch !"));
        }
        UserService userService = new UserService();
        userService.createUser(signupParams.name, signupParams.email, signupParams.password);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
