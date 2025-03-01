package com.derek.nasa_social_media_app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserProfile {
    
    
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String userPassword;


    @OneToMany(mappedBy = "userProfiles")
	@JsonIgnore
	private List<UserPosts> posts;

    public UserProfile(Integer id, String username, String userPassword) {
        this.id = id;
        this.username = username;
        this.userPassword = userPassword;
    }

    public UserProfile(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ", username=" + username + ", userPassword=" + userPassword + "]";
    }

  

    
}
