package com.example.course.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "lecturer")
public class Lecturer {


    @Id
    @Indexed(unique=true)
    private Integer id;
    private String lecturerName;
    private String email;

}
