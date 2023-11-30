package com.example.firstproject.repository;

import com.example.firstproject.entity.Marks;
import com.example.firstproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
