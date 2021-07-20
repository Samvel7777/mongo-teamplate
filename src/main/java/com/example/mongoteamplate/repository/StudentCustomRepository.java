package com.example.mongoteamplate.repository;

import com.example.mongoteamplate.model.Gender;
import com.example.mongoteamplate.model.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentCustomRepository {

    public List<Student> findStudentsByProperties(
            String name, String email, String subjectRef, String collegeRef, Gender gender,
            Pageable page);
}
