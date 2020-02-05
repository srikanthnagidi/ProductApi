package com.eshopping.product.dashboard.controller;

import com.eshopping.product.dashboard.model.User;
import com.eshopping.product.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        Optional<User> user1 = userRepository.findByUsername(user.getUsername());
        if (user1.isPresent()){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
