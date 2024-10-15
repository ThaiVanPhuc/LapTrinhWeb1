package com.example.BaiGiuaKy.service;

import com.example.BaiGiuaKy.models.Lesson;
import com.example.BaiGiuaKy.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findById(String id) {
        return lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void delete(String id) {
        lessonRepository.deleteById(id);
    }
}
