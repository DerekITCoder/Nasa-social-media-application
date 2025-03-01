package com.derek.nasa_social_media_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserPosts {

@Id
@GeneratedValue
private Integer id;

private String text;

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
private UserProfile userProfiles;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getText() {
    return text;
}

public void setText(String text) {
    this.text = text;
}

public UserProfile getUserProfiles() {
    return userProfiles;
}

public void setUserProfiles(UserProfile userProfiles) {
    this.userProfiles = userProfiles;
}

@Override
public String toString() {
    return "UserPosts [id=" + id + ", text=" + text + ", userProfiles=" + userProfiles + "]";
}






    
}
