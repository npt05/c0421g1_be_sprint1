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
//@NoArgsConstructor
//@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    private String subjectName;

    @OneToMany(mappedBy = "subject")
    private Set<Mark> marks;

    @OneToMany(mappedBy = "subject")
    private Set<ScheduleDetail> scheduleDetails;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Set<ScheduleDetail> getScheduleDetails() {
        return scheduleDetails;
    }

    public void setScheduleDetails(Set<ScheduleDetail> scheduleDetails) {
        this.scheduleDetails = scheduleDetails;
    }
}
