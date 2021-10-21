package com.codegym.entity.about_schedule;

import com.codegym.entity.about_student.Mark;
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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private Set<ScheduleDetail> scheduleDetail;

    @OneToMany(mappedBy = "subject")
    private Set<Mark> marks;

    @OneToMany(mappedBy = "subject")
    private Set<ScheduleDetail> scheduleDetails;
}
