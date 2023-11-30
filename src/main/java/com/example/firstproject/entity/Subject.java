package com.example.firstproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject",uniqueConstraints = {@UniqueConstraint(columnNames = "subjectName")})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String subjectName;

    private String teacherName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
