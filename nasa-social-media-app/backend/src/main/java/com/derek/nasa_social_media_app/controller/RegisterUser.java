package com.derek.nasa_social_media_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisterUser {

    @Autowired
    private UserProfileRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public UserProfile createUser(@RequestBody UserProfile user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return myUserRepository.save(user);
    
}
    
}
