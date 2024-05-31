package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.exception.CourseNotFoundException;
import com.example.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> findCourseById(Long courseId) {
        return Optional.ofNullable(courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not exist with id: " + courseId)));
    }


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public ResponseEntity<Void> updateCourse(Long courseId, Course course) {

        Course courseStudent=courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not exist with id: " + courseId));
        courseStudent.setId(course.getId());
        courseStudent.setCourseName(course.getCourseName());
        courseStudent.setHours(course.getHours());
        courseStudent.setClassRoom(course.getClassRoom());

        courseRepository.save(courseStudent);
        return null;
    }

    public void deleteCourse(Long courseId) {
        Course courseStudent=courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not exist with id: " + courseId));
        courseRepository.delete(courseStudent);

    }
}
