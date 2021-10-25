package com.codegym.dto;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.Set;


//LamNT create StudentDto and Validate

public class StudentDto {
    //    private Integer studentId;
//    private Byte studentGender;
////    @NotEmpty(message = "Họ và tên cha không được để trống.")
////    @Size(min = 5, message = "Họ và tên cha phải nhiều hơn 5 chữ cái.")
//    private String studentFatherName;
////    @NotEmpty(message = "Họ và tên mẹ không được để trống.")
//    private String studentMotherName;
////    @NotBlank(message = "Ngày sinh không được để trống.")
//    private String studentDateOfBirth;
////    @NotEmpty(message = "Dân tộc không được để trống.")
//    private String studentEthnicity;
////    @NotEmpty(message = "Quê quán không được để trống.")
//    private String studentAddress;
////    @NotEmpty(message = "Họ và tên học sinh không được để trống.")
////    @Size(min = 5, message = "Họ và tên học sinh phải nhiều hơn 5 chữ cái.")
//    private String studentName;
//    private String studentReligion;
//    private String studentImage;
//    private String studentStatus;
////    @Pattern(regexp = "^(09[0|1])+([0-9]{7})\\b$", message = "Số điện thoại sai định dạng." +
////            "\n VD:090xxxxxxx, x gồm 7 chữ số")
//    private String studentParentPhone;
//    private boolean deleteFlag;
    private Integer studentId;
    private Byte studentGender;
    private String studentFatherName;
    private String studentMotherName;
    private String studentDateOfBirth;
    private String studentEthnicity;
//    @NotBlank
    private String studentAddress;
//    @NotNull(message = "Họ và tên học sinh không được để trống")
////    @Pattern(regexp="^[A-Za-z]*$",message = "Họ và tên học sinh không được nhập số và ký tự đặc biệt")
//    @Size(min = 5, max = 50, message = "Họ và tên học sinh phải lớn hơn 5 và nhỏ hơn 50")
    private String studentName;
    private String studentReligion;
    private String studentImage;
    private String studentStatus;
    private String studentParentPhone;
    private boolean deleteFlag;

    private Classroom classroom;

    private Set<Mark> marks;

    public StudentDto() {
    }

    public StudentDto(Integer studentId, Byte studentGender, String studentFatherName, String studentMotherName, String studentDateOfBirth, String studentEthnicity, String studentAddress, String studentName, String studentReligion, String studentImage, String studentStatus, String studentParentPhone, boolean deleteFlag, Classroom classroom, Set<Mark> marks) {
        this.studentId = studentId;
        this.studentGender = studentGender;
        this.studentFatherName = studentFatherName;
        this.studentMotherName = studentMotherName;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentEthnicity = studentEthnicity;
        this.studentAddress = studentAddress;
        this.studentName = studentName;
        this.studentReligion = studentReligion;
        this.studentImage = studentImage;
        this.studentStatus = studentStatus;
        this.studentParentPhone = studentParentPhone;
        this.deleteFlag = deleteFlag;
        this.classroom = classroom;
        this.marks = marks;
    }

    public StudentDto(Byte studentGender, String studentFatherName, String studentMotherName, String studentDateOfBirth, String studentEthnicity, String studentAddress, String studentName, String studentReligion, String studentImage, String studentStatus, String studentParentPhone, boolean deleteFlag, Classroom classroom, Set<Mark> marks) {
        this.studentGender = studentGender;
        this.studentFatherName = studentFatherName;
        this.studentMotherName = studentMotherName;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentEthnicity = studentEthnicity;
        this.studentAddress = studentAddress;
        this.studentName = studentName;
        this.studentReligion = studentReligion;
        this.studentImage = studentImage;
        this.studentStatus = studentStatus;
        this.studentParentPhone = studentParentPhone;
        this.deleteFlag = deleteFlag;
        this.classroom = classroom;
        this.marks = marks;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Byte getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(Byte studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
    }

    public String getStudentMotherName() {
        return studentMotherName;
    }

    public void setStudentMotherName(String studentMotherName) {
        this.studentMotherName = studentMotherName;
    }

    public String getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(String studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentEthnicity() {
        return studentEthnicity;
    }

    public void setStudentEthnicity(String studentEthnicity) {
        this.studentEthnicity = studentEthnicity;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentReligion() {
        return studentReligion;
    }

    public void setStudentReligion(String studentReligion) {
        this.studentReligion = studentReligion;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentParentPhone() {
        return studentParentPhone;
    }

    public void setStudentParentPhone(String studentParentPhone) {
        this.studentParentPhone = studentParentPhone;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }
}
