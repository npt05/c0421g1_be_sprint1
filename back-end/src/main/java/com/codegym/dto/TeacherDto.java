package com.codegym.dto;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class TeacherDto {
    private Integer teacherId;
    private String teacherName;
    private Byte teacherGender;
    private Date teacherDateOfBirth;
    private String teacherUniversity;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherImage;
    private boolean deleteFlag;
    private Degree degree;
    private Division division;
    private Classroom classroom;
    private Account account;
    public TeacherDto() {
    }

    public TeacherDto(Integer teacherId, String teacherName, Byte teacherGender, Date teacherDateOfBirth, String teacherUniversity, String teacherAddress, String teacherEmail, String teacherPhone, String teacherImage, boolean deleteFlag, Degree degree, Division division, Classroom classroom, Account account) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherDateOfBirth = teacherDateOfBirth;
        this.teacherUniversity = teacherUniversity;
        this.teacherAddress = teacherAddress;
        this.teacherEmail = teacherEmail;
        this.teacherPhone = teacherPhone;
        this.teacherImage = teacherImage;
        this.deleteFlag = deleteFlag;
        this.degree = degree;
        this.division = division;
        this.classroom = classroom;
        this.account = account;
    }
}
