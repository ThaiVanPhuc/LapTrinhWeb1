package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.service.LichGiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lich")
public class API_TKBController {

    @Autowired
    private LichGiangVienService lichGiangVienService;

    @GetMapping
    public ResponseEntity<List<LichGiangVien>> getAllSchedules() {
        List<LichGiangVien> schedules = lichGiangVienService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichGiangVien> getScheduleById(@PathVariable Long id) {
        Optional<LichGiangVien> schedule = lichGiangVienService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<LichGiangVien> addSchedule(@RequestBody LichGiangVien schedule) {
        LichGiangVien savedSchedule = lichGiangVienService.saveSchedule(schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<LichGiangVien> updateSchedule(@PathVariable Long id, @RequestBody LichGiangVien schedule) {
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
            return ResponseEntity.ok(updatedSchedule);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        lichGiangVienService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
