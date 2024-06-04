package com.example.course.service;


import com.example.course.entity.Course;
import com.example.course.entity.Lecturer;
import com.example.course.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }
}
