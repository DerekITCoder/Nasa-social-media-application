package com.derek.nasa_social_media_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.derek.nasa_social_media_app.model.UserPosts;

public interface UserPostsRepository extends CrudRepository<UserPosts, Integer>  {
    
}
