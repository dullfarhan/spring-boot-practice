package com.practice.rest.service;

import org.springframework.data.mongodb.core.mapping.String;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.practice.rest.entity.User;
import com.practice.rest.repository.UserRepository;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        final User newUser = userRepository.save(user);
        return newUser;

    }

    public Boolean delete(String id) {
        userRepository.deleteById(id);
        return true;

    }

    public User update(String id, User newUser) {
         User user = userRepository.findById(id).orElse(null);
        if (user != null){
             String newEmail = newUser.getEmail();
             String newName = newUser.getName();
             user.setEmail(newEmail);
             user.setName(newName);
              user = userRepository.save(user);
            return user;
        }
        else{
            return null;
        }

    }

    public List<User> getAll() {
        final List<User> users = userRepository.findAll();
        return users;

    }

    public Optional<User> getById(String id) {
        final Optional<User> user = userRepository.findById(id);
        return user;

    }

}
