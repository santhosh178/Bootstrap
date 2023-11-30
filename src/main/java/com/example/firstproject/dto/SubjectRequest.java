package com.example.firstproject.dto;

import javax.validation.constraints.NotBlank;

public class SubjectRequest {
    @NotBlank
    private  long id;
    @NotBlank
    private String subjectName;

    @NotBlank
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
