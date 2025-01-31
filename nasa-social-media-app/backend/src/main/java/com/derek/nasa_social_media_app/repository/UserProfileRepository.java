package com.derek.nasa_social_media_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.derek.nasa_social_media_app.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long>  {
    
}
