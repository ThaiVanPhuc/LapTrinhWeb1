package com.example.Lab05.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.Lab05.models.User;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    List<User> ListUser = new ArrayList<>();

    public UserController() {
        User u1 = new User("1", "Thai Van Phuc", "phuc@gmail.com");
        User u2 = new User("2", "Thai Van Phuc", "phuc@gmail.com");
        ListUser.add(u1);
        ListUser.add(u2);
    }

    // Get all Users
    @GetMapping("/users")
    @ResponseBody
    public List<User> getListUsers() {
        return ListUser;
    }

    // Get user by id
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable("id") String userId) {
        for (User user : ListUser) {
            if (user.getId().equals(userId)) {
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    // create new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        ListUser.add(newUser);
        return ResponseEntity.status(201).body(newUser);
    }

    // API delete user by id
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public List<User> deleteUsers(@PathVariable("id") String userID) {
        for (User user : ListUser) {
            if (user.getId().equals(userID)) {
                ListUser.remove(user);
                break;
            }
        }
        return ListUser;
    }

    // API PUT user by id
    @PutMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody User updateUser) {
        for (User user : ListUser) {
            if (user.getId().equals(userId)) {
                user.setName(updateUser.getName());
                user.setEmail(updateUser.getEmail());
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @PatchMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<User> partialUpdateUser(@PathVariable("id") String userId,
            @RequestBody Map<String, Object> updates) {
        for (User user : ListUser) {
            if (user.getId().equals(userId)) {
                if (updates.containsKey("name")) {
                    user.setName((String) updates.get("name"));
                }
                if (updates.containsKey("email")) {
                    user.setEmail((String) updates.get("email"));
                }
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body(null);
    }
}