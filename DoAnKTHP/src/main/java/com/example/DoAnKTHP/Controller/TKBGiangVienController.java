package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.models.LichGiangVien;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lich")
public class TKBGiangVienController {

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    @GetMapping("/giangvien")
    public String getThoiKhoaBieu(@RequestParam("giangVienId") Long giangVienId, Model model, HttpSession session) {
        List<LichGiangVien> lichGiangVienList = lichGiangVienRepository.findByGiangVienId(giangVienId);
        model.addAttribute("thoiKhoaBieu", lichGiangVienList);
        return "thoiKhoaBieu";
    }

    @GetMapping("/timgiangvien")
    public String timgiangvine() {
        return "index";
    }
}
