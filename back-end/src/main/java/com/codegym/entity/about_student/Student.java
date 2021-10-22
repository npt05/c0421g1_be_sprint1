package com.codegym.entity.about_student;

import com.codegym.entity.about_classroom.Classroom;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "studentId")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private Byte studentGender;
    private String studentFatherName;
    private String studentMotherName;
    private Date studentDateOfBirth;
    private String studentEthnicity;
    private String studentAddress;
    private String studentName;
    private String studentReligion;
    private String studentImage;
    private String studentStatus;
    private String studentParentPhone;
    private boolean deleteFlag;

    @JsonManagedReference(value = "student_classroom")
    @ManyToOne(targetEntity = Classroom.class)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    @JsonManagedReference(value = "student_mark")
    @OneToMany(mappedBy = "student")
    private Set<Mark> marks;
}
