package com.example.DoAnKTHP.service;

import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.models.User;

@Service
public interface UserService {

    User findByUsername(String username);
}