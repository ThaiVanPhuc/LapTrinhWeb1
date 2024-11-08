package com.example.DoAnKTHP.service;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.Repository.LichLopRepository;
import com.example.DoAnKTHP.Repository.LichPhongMayRepository;
import com.example.DoAnKTHP.models.LichDeXuat;
import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.models.LichLop;
import com.example.DoAnKTHP.models.LichPhongMay;
import com.example.DoAnKTHP.models.UserGV;

import jakarta.servlet.http.HttpSession;

@Service
public class LichDeXuatService {

    @Autowired
    private LichPhongMayRepository lichPhongMayRepository;

    @Autowired
    private LichLopRepository lichLopRepository;

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    public List<LichDeXuat> getLichDeXuat()
}
