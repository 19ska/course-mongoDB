package com.example.course.repository;

import com.example.course.entity.Lecturer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LecturerRepository extends MongoRepository<Lecturer, Long> {
}
