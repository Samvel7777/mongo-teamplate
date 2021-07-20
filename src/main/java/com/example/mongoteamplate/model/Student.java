package com.example.mongoteamplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private String email;
    private List<String> subjectRefs;
    private String collegeRef;
    private Gender gender;
}
