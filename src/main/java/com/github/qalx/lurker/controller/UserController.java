package com.github.qalx.lurker.controller;

import com.github.qalx.lurker.model.User;
import com.github.qalx.lurker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(value = "{id}")
            public User deleteUserById(@PathVariable long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }
}
