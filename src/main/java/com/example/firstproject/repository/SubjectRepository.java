package com.example.firstproject.repository;

import com.example.firstproject.entity.Marks;
import com.example.firstproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
