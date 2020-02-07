package com.login.service.loginservice.controller;

import com.login.service.loginservice.model.User;
import com.login.service.loginservice.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        try {
            User user1 = userService.findUserByUsername(user.getUsername());
            return ResponseEntity.notFound().build();
        } catch (UsernameNotFoundException e) {
            userService.saveUser(user);
        }
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
