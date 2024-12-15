package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.service.LichGiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/lich")
public class AdminTKBController {
    @Autowired
    private LichGiangVienService lichGiangVienService;

    @GetMapping
    public String listSchedules(Model model) {
        model.addAttribute("schedules", lichGiangVienService.getAllSchedules());
        return "admin/list";
    }

    @GetMapping("/add")
    public String addScheduleForm(Model model) {
        model.addAttribute("schedule", new LichGiangVien());
        return "admin/add";
    }

    @PostMapping("/add")
    public String saveSchedule(@ModelAttribute LichGiangVien schedule) {
        lichGiangVienService.saveSchedule(schedule);
        return "redirect:/admin/lich";
    }

    @GetMapping("/edit/{id}")
    public String editScheduleForm(@PathVariable Long id, Model model) {
        Optional<LichGiangVien> schedule = lichGiangVienService.getScheduleById(id);
        if (schedule.isPresent()) {
            model.addAttribute("schedule", schedule.get());
            return "admin/edit";
        }
        return "redirect:/admin/lich";
    }

    @PutMapping("/edit/{id}")
    public String updateSchedule(@PathVariable Long id, @ModelAttribute LichGiangVien schedule) {
        Optional<LichGiangVien> existingSchedule = lichGiangVienService.getScheduleById(id);
        if (existingSchedule.isPresent()) {
            LichGiangVien updatedSchedule = existingSchedule.get();
            updatedSchedule.setGiangVien(schedule.getGiangVien());
            updatedSchedule.setCa(schedule.getCa());
            updatedSchedule.setThu(schedule.getThu());
            updatedSchedule.setNgay(schedule.getNgay());
            updatedSchedule.setPhong(schedule.getPhong());
            updatedSchedule.setHocPhan(schedule.getHocPhan());
            updatedSchedule.setLopHoc(schedule.getLopHoc());
            lichGiangVienService.saveSchedule(updatedSchedule);
        }
        return "redirect:/admin/lich";
    }

    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        lichGiangVienService.deleteSchedule(id);
        return "redirect:/admin/lich";
    }
}
