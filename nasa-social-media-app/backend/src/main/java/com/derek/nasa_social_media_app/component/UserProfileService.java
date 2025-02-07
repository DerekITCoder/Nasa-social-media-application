package com.derek.nasa_social_media_app.component;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.derek.nasa_social_media_app.model.UserProfile;
import com.derek.nasa_social_media_app.repository.UserProfileRepository;


@Service
public class UserProfileService implements UserDetailsService {
    
    @Autowired
    private UserProfileRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserProfile> user = repository.findByUsername(username);
        if (user.isPresent()) {
            UserProfile userObj = user.get();
            return User.builder()
            .username(userObj.getUsername())
            .password(userObj.getUserPassword())
            .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }




}
