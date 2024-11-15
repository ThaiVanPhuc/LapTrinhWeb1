package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.GiangVienRepository;
import com.example.DoAnKTHP.models.GiangVien;

@Service
public class UserGVService {

    @Autowired
    private GiangVienRepository userGVRepository;

    public GiangVien findUserByUsername(String tenGiangVien) {
        return userGVRepository.findByTenGiangVien(tenGiangVien);
    }

    public void saveUser(GiangVien user) {
        userGVRepository.save(user);
    }
}
