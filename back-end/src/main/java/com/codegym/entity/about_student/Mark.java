package com.codegym.entity.about_student;

import com.codegym.entity.about_schedule.Subject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markId;

    @JsonBackReference
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    private Student student;

    @JsonBackReference
    @ManyToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subject_id",referencedColumnName = "subjectId")
    private Subject subject;

    private Double markPointNumber1;
    private Double markPointNumber2;
    private Double markPointNumber3;

    public Mark() {
    }

    public Mark(Integer markId, Student student, Subject subject, Double markPointNumber1, Double markPointNumber2, Double markPointNumber3) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.markPointNumber1 = markPointNumber1;
        this.markPointNumber2 = markPointNumber2;
        this.markPointNumber3 = markPointNumber3;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getMarkPointNumber1() {
        return markPointNumber1;
    }

    public void setMarkPointNumber1(Double markPointNumber1) {
        this.markPointNumber1 = markPointNumber1;
    }

    public Double getMarkPointNumber2() {
        return markPointNumber2;
    }

    public void setMarkPointNumber2(Double markPointNumber2) {
        this.markPointNumber2 = markPointNumber2;
    }

    public Double getMarkPointNumber3() {
        return markPointNumber3;
    }

    public void setMarkPointNumber3(Double markPointNumber3) {
        this.markPointNumber3 = markPointNumber3;
    }
}
