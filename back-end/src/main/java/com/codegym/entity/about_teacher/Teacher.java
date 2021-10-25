package com.codegym.entity.about_teacher;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacherName;
    private Byte teacherGender;
    private Date teacherDateOfBirth;
    private String teacherUniversity;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherImage;

    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id", referencedColumnName = "degreeId")
    private Degree degree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    private boolean deleteFlag;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Byte getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(Byte teacherGender) {
        this.teacherGender = teacherGender;
    }

    public Date getTeacherDateOfBirth() {
        return teacherDateOfBirth;
    }

    public void setTeacherDateOfBirth(Date teacherDateOfBirth) {
        this.teacherDateOfBirth = teacherDateOfBirth;
    }

    public String getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(String teacherUniversity) {
        this.teacherUniversity = teacherUniversity;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherImage() {
        return teacherImage;
    }

    public void setTeacherImage(String teacherImage) {
        this.teacherImage = teacherImage;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}