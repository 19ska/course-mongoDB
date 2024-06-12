package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.findCourseById(courseId);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> students=courseService.getAllCourses();
        return ResponseEntity.ok(students);
    }

    @PutMapping
    public ResponseEntity<Void> updateCourse(@RequestParam Long courseId, @RequestBody Course course ){
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<Void> deleteCourse(@RequestParam Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }
}
