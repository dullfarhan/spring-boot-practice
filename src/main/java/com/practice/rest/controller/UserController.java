package com.practice.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.entity.User;
import com.practice.rest.service.UserService;

@RestController()
@RequestMapping("/user")
public class UserController

{
    @Autowired
    private UserService userService;

    @PostMapping()
    public User create(@RequestBody User body) {

        User newUser = userService.create(body);
        return newUser;
    }

    @PutMapping("{id}")
    public User Update(@RequestBody User body, @PathVariable String id) {

        User newUser = userService.update(id, body);
        return newUser;
    }

    @GetMapping
    public List<User> getAll() {

        List<User> users = userService.getAll();
        return users;
    }

    @GetMapping("{id}")
    public User get(@PathVariable("id") String id) {
        User user = userService.getById(id).orElse(null);
        if (user != null) {
            return user;
        }
        return null;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") String id) {
        boolean deleted = userService.delete(id);
        return deleted;
    }

}