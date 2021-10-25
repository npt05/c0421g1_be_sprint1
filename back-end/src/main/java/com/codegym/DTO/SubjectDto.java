package com.codegym.DTO;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.entity.about_student.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

    private Integer subjectId;
    private String subjectName;
    private Set<ScheduleDetail> scheduleDetails;
    private Set<Mark> marks;


}
