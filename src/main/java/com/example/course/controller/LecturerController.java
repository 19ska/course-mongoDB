package com.example.course.controller;


import com.example.course.entity.Lecturer;
import com.example.course.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lec")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @PostMapping
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
        Lecturer createdLecturer = lecturerService.createLecturer(lecturer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLecturer);
    }

    @GetMapping
    public ResponseEntity<List<Lecturer>> getLecturerByName(@RequestParam String lecturerName){
        List<Lecturer> lecturers=lecturerService.getLecturerByName(lecturerName);
        return ResponseEntity.ok().body(lecturers);
    }
}
