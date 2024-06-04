package com.example.course.repository;

import com.example.course.entity.Lecturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LecturerRepository extends MongoRepository<Lecturer, Long> {

    @Query("{'lecturerName':{$regex:?0, $options:'i'}}")
    List<Lecturer> findByNameContainingIgnoreCaseCustom(String name);
}
