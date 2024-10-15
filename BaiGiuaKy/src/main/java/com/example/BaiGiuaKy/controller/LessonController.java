package com.example.BaiGiuaKy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.BaiGiuaKy.models.Lesson;
import com.example.BaiGiuaKy.service.LessonService;

@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Get all Lessons
    @GetMapping("/lessons")
    @ResponseBody
    public List<Lesson> getLessons() {
        return lessonService.findAll();
    }

    // Get Lesson by id
    @GetMapping("/lessons/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable("id") String lessonId) {
        try {
            Lesson lesson = lessonService.findById(lessonId);
            return ResponseEntity.ok().body(lesson);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Create new Lesson (Admin only)
    @PostMapping("/lessons")
    @ResponseBody
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson newLesson) {
        Lesson savedLesson = lessonService.save(newLesson);
        return ResponseEntity.status(201).body(savedLesson);
    }

    // Update Lesson by id (Admin only)
    @PutMapping("/lessons/{id}")
    @ResponseBody
    public ResponseEntity<Lesson> updateLesson(@PathVariable("id") String lessonId, @RequestBody Lesson updateLesson) {
        try {
            Lesson existingLesson = lessonService.findById(lessonId);
            existingLesson.setTitle(updateLesson.getTitle());
            existingLesson.setContent(updateLesson.getContent());
            lessonService.save(existingLesson);
            return ResponseEntity.ok().body(existingLesson);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Delete Lesson by id (Admin only)
    @DeleteMapping("/lessons/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteLesson(@PathVariable("id") String lessonId) {
        try {
            lessonService.delete(lessonId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
