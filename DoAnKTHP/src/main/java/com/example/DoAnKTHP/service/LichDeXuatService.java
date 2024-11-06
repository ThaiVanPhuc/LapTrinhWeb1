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

    public List<LichDeXuat> laylichDeXuat(String lop, HttpSession session) {
        List<LichDeXuat> danhSachDeXuat = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        // Lấy giảng viên từ session
        UserGV giangVien = (UserGV) session.getAttribute("USERS");
        if (giangVien == null) {
            System.out.println("Không tìm thấy thông tin giảng viên trong session.");
            return danhSachDeXuat; // Trả về danh sách trống nếu không có giảng viên
        }

        // Lặp qua các ngày từ hiện tại đến thứ Bảy
        for (int i = 0; i < 7; i++) {
            LocalDate localDate = LocalDate.now();
            Date ngay = java.sql.Date.valueOf(localDate);
            for (int ca = 1; ca <= 5; ca++) {
                // Lấy danh sách phòng trống
                List<LichPhongMay> danhSachPhongTrong = lichPhongMayRepository.findByPhongAndNgayAndCa(ngay, ca,
                        true);

                List<LichLop> lopHoc = lichLopRepository.findByLopAndNgayAndCa(lop, ngay, ca);
                List<LichGiangVien> lichGV = lichGiangVienRepository
                        .findByGiangVienAndNgayAndCa(giangVien.getUserName(), ngay, ca);

                if (lopHoc.isEmpty() && lichGV.isEmpty()) {
                    List<String> danhSachPhong = new ArrayList<>();
                    for (LichPhongMay phongTrong : danhSachPhongTrong) {
                        danhSachPhong.add(phongTrong.getPhong());
                    }

                    LichDeXuat lichDeXuat = new LichDeXuat();
                    lichDeXuat.setNgay(ngay);
                    lichDeXuat.setCa(ca);
                    lichDeXuat.setPhong(danhSachPhong);
                    lichDeXuat.setGiangVien(giangVien.getUserName());
                    lichDeXuat.setLop(lop);

                    danhSachDeXuat.add(lichDeXuat);
                }
            }
            calendar.add(Calendar.DATE, 1);
        }

        return danhSachDeXuat;
    }

    public List<LichLop> getClassesForTeacher(String username) {
        return lichLopRepository.findByTeacherUsername(username); // Lấy lớp giảng viên dạy từ repository
    }
}
