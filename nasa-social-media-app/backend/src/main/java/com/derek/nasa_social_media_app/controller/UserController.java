package com.derek.nasa_social_media_app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.component.UserService;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

@Controller
public class UserController {
    

  // @Autowired
  // private UserProfileRepository repository;

  






    // @GetMapping("/users/get")
    // public List<UserProfile> getAllUsers() {
    //     return (List<UserProfile>) repository.findAll();
    // }


    // @PostMapping("/users/save")
    // public UserProfile createUser(@RequestBody UserProfile userProfile) {
    //     return repository.save(userProfile);
    // }

    @GetMapping("/home")
    public String handleUserHome() {
      return "home_users";
    }


    @GetMapping("/login")
    public String loginPage() {
      return "loginPage";
    }



    // @GetMapping("/names")
    // public void getAllNames() {
    //     service.getNames();
    // } 

    @GetMapping("/names")
    public List<String> findAllOnlyNames() {
    List<UserProfile> users = (List<UserProfile>) repository.findAll();
    return users.stream()
            .map(UserProfile::getUsername)
            .collect(Collectors.toList());
}
    
    
    



}
