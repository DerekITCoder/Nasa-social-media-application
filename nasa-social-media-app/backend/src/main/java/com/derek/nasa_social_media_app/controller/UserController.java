package com.derek.nasa_social_media_app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.derek.nasa_social_media_app.component.UserService;
import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;

@RestController
public class UserController {
    
    @Autowired
    private UserProfileRepository repository;

    private UserService service;




    public UserController(UserProfileRepository repository,UserService service) {
        this.repository = repository;
        this.service = service;
    }


    @GetMapping("/users/get")
    public List<UserProfile> getAllUsers() {
        return (List<UserProfile>) repository.findAll();
    }


    @PostMapping("/users/save")
    public UserProfile createUser(@RequestBody UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @GetMapping("/users/home")
    public String handleUserHome() {
      return "home_users";
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
