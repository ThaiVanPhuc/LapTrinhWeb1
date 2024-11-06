package com.example.DoAnKTHP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DoAnKTHP.models.LichDeXuat;
import com.example.DoAnKTHP.service.LichDeXuatService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LichDeXuatController {

    @Autowired
    private LichDeXuatService lichDeXuatService;

    // API lấy lịch dạy đề xuất cho lớp
    @GetMapping("/lich-de-xuat/{lopId}")
    public List<LichDeXuat> layLichDeXuat(@PathVariable("lopId") String lopId, HttpSession session) {
        return lichDeXuatService.laylichDeXuat(lopId, session); // Trả về danh sách lịch dạy dưới dạng JSON
    }
}
