package com.codegym.entity.about_teacher;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id", referencedColumnName = "degreeId")
    private Degree degree;

    @JsonBackReference
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;


    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    private boolean deleteFlag;
}
