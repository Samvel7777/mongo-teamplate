package com.example.mongoteamplate.endpoint;

import com.example.mongoteamplate.model.Gender;
import com.example.mongoteamplate.model.Student;
import com.example.mongoteamplate.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public static class RegisterRequest {
        public String name;
        public String email;
        public List<String> subjectRefs;
        public String collegeRef;
        public Gender gender;
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody RegisterRequest request) {

        if (!request.name.isEmpty()) {
            return ResponseEntity.badRequest().body("NAME IS NULL");
        }

        if (!request.email.isEmpty()) {
            return ResponseEntity.badRequest().body("EMAIL IS NULL");
        }

        if (!request.subjectRefs.isEmpty()) {
            return ResponseEntity.badRequest().body("SUBJECT IS NULL");
        }

        if (!request.collegeRef.isEmpty()) {
            return ResponseEntity.badRequest().body("COLLEGE IS NULL");
        }

        if (request.gender == null) {
            return ResponseEntity.badRequest().body("GENDER IS NULL");
        }

        Student student = studentService.addStudent(
                request.name, request.email, request.subjectRefs, request.collegeRef, request.gender);

        return ResponseEntity.status(201).body(student);
    }

    @GetMapping
    public ResponseEntity<?> getStudentsByProperties(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) String email,
                                                     @RequestParam(required = false) String subjectRef,
                                                     @RequestParam(required = false) String collegeRef,
                                                     @RequestParam(required = false) Gender gender,
                                                     @RequestParam Integer page) {
        return ResponseEntity.ok().body(studentService.fetchStudentsByProperties(name, email,
                subjectRef, collegeRef, gender, page));
    }
}
