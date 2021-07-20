package com.example.mongoteamplate.service;

import com.example.mongoteamplate.model.Gender;
import com.example.mongoteamplate.model.Student;
import com.example.mongoteamplate.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(String name, String email, List<String> subjectRefs,
                              String collegeRef, Gender gender) {

        Student student = Student.builder()
                .name(name)
                .email(email)
                .subjectRefs(subjectRefs)
                .collegeRef(collegeRef)
                .gender(gender)
                .build();

        return studentRepository.save(student);
    }

    public List<Student> fetchStudentsByProperties(String name, String email, String subjectRef,
                                                   String collegeRef, Gender gender, Integer page) {

        return studentRepository.findStudentsByProperties(name, email, subjectRef, collegeRef,
                gender, PageRequest.of(page, 15));
    }

}
