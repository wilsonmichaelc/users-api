package com.wilson.seed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import com.wilson.seed.exception.ResourceNotFoundException;
import com.wilson.seed.model.User;
import com.wilson.seed.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{guid}")
    public User getUser(@PathVariable String guid) {
        return userRepository.findByGuid(guid);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{guid}")
    public User updateUser(@PathVariable String guid, @Valid @RequestBody User userReq) {
        User user;
        try {
            user = userRepository.findByGuid(guid);
            user.setName(userReq.getName());
            user.setEmail(userReq.getEmail());
            user.setPhone(userReq.getPhone());
            user.setAddressOne(userReq.getAddressOne());
            user.setAddressTwo(userReq.getAddressTwo());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with guid " + guid);
        }
    }


    @DeleteMapping("/users/{guid}")
    public ResponseEntity<?> deleteUser(@PathVariable String guid) {
        User user;
        try {
            user = userRepository.findByGuid(guid);
            userRepository.delete(user);
                    return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id " + guid);
        }
    }
}