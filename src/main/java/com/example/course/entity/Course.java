package com.example.course.entity;


import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "course")
public class Course {

    @Id
    @Indexed(unique=true)
    private Integer id;
    private String courseName;
    private String hours;
    private String classRoom;
    private Lecturer lecturer;

}
