package com.example.course.controller;


import com.example.course.entity.Course;
import com.example.course.entity.Lecturer;
import com.example.course.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
