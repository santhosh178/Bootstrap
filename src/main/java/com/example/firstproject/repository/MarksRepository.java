package com.example.firstproject.repository;

import com.example.firstproject.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarksRepository extends JpaRepository<Marks,Long> {

    List<Marks> findByStudentId(long studentId);
}
