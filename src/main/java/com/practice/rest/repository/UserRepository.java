package com.practice.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.rest.entity.User;

public interface UserRepository  extends MongoRepository<User, String> {
    
}
