package com.example.ims.controllers;

import com.example.ims.controllers.beans.ForgotPasswordParameters;
import com.example.ims.controllers.beans.LoginParameters;
import com.example.ims.controllers.beans.LoginResponse;
import com.example.ims.entities.User;
import com.example.ims.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {
    @PostMapping("/login")
    @ResponseBody
    public LoginResponse Login(@RequestBody LoginParameters loginParameters) {
        UserService userService = new UserService();
        Optional<User> user = userService.findByEmail(loginParameters.getEmail());
        if(!user.isPresent() || userService.isValidPassword(user.get(), loginParameters.getPassword())) {
            return new LoginResponse("Invalid Email/Password !");
        }
        return new LoginResponse(user.get());
    }

    @GetMapping("/forgotPassword")
    @ResponseBody
    public ResponseEntity ForgotPassword(@RequestBody ForgotPasswordParameters forgotPasswordParameters) {
        UserService userService = new UserService();
        userService.sendForgetPasswordEmail(forgotPasswordParameters.getEmail());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
