package com.example.mongoteamplate.repository;

import com.example.mongoteamplate.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>, StudentCustomRepository {
}
