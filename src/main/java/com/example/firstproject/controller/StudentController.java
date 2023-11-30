package com.example.firstproject.controller;

import com.example.firstproject.dto.MarksRequest;
import com.example.firstproject.entity.Marks;
import com.example.firstproject.entity.Student;
import com.example.firstproject.entity.Subject;
import com.example.firstproject.dto.ApiResponse;
import com.example.firstproject.dto.StudentRequest;
import com.example.firstproject.dto.SubjectRequest;
import com.example.firstproject.exception.BadRequestException;
import com.example.firstproject.repository.MarksRepository;
import com.example.firstproject.repository.StudentRepository;
import com.example.firstproject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarksRepository marksRepository;

    @PostMapping("/add_student")
    public ResponseEntity<?> register(@RequestBody StudentRequest studentRequest) {

        Student student  = new Student();
        student.setName(studentRequest.getName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setGender(studentRequest.getGender());

        Student result = studentRepository.save(student);

        return ResponseEntity.ok(new ApiResponse(true,"student registered successfully"));
    }

    @PostMapping("/add_subject")
    public ResponseEntity<?> addSubject(@RequestBody SubjectRequest subjectRequest) {

        Subject subject = new Subject();
        subject.setSubjectName(subjectRequest.getSubjectName());
        subject.setTeacherName(subjectRequest.getTeacherName());

        Subject result = subjectRepository.save(subject);

        return ResponseEntity.ok(new ApiResponse(true,"subject added successfully"));
    }

    @PostMapping("/add_marks")
    public ResponseEntity<?> addMarks(@RequestBody MarksRequest marksRequest) {

        Student student = studentRepository.findById(marksRequest.getStudent_id()).orElseThrow(()->new BadRequestException("Student not found ."));
        Subject subject = subjectRepository.findById(marksRequest.getSubject_id()).orElseThrow(()->new BadRequestException("subject not found"));

        Marks mark = new Marks();
        mark.setMarks(marksRequest.getMarks());
        mark.setStudent(student);
        mark.setSubject(subject);

        Marks result2 = marksRepository.save(mark);

        return ResponseEntity.ok(new ApiResponse(true, "marks added successfully"));
    }

    @GetMapping("/get_student_marks")
    public List<Marks> getStudentMarks(@RequestParam long studentId) {
        return marksRepository.findByStudentId(studentId);
    }
}
