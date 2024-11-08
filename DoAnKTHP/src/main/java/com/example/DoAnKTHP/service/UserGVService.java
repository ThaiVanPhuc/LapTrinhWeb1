package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.UserGVRepository;
import com.example.DoAnKTHP.models.GiangVien;

@Service
public class UserGVService {

    @Autowired
    private UserGVRepository userGVRepository;

    public GiangVien findUserByUsername(String username) {
        return userGVRepository.findUserGVByUserName(username);
    }

    public void saveUser(GiangVien user) {
        userGVRepository.save(user);
    }
}
