package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.UserGVRepository;
import com.example.DoAnKTHP.models.UserGV;

@Service
public class UserGVService {

    @Autowired
    private UserGVRepository userGVRepository;

    public UserGV findUserByUsername(String username) {
        return userGVRepository.findUserGVByUserName(username);
    }

    public void saveUser(UserGV user) {
        userGVRepository.save(user);
    }
}
