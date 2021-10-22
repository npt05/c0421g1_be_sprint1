package com.codegym.entity.about_classroom;

import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    private String classroomName;
    private String classroomSchoolYear;

    @JsonBackReference
    @ManyToOne(targetEntity = Grade.class)
    @JoinColumn(name = "grade_id", referencedColumnName = "gradeId")
    private Grade grade;

    private boolean deleteFlag;

    @OneToOne(mappedBy = "classroom")
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom")
    private Set<Student> students;

    @OneToOne(mappedBy = "classroom")
    private Schedule schedule;


}
