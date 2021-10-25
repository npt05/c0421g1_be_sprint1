package com.codegym.DTO;

import com.codegym.entity.about_schedule.ScheduleDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyDayTimeDto {
    private Integer studyDayTimeId;
    private String studyDayTimeStudyTime;
    private String studyDayTimeStudyDay;

    private Set<ScheduleDetail> scheduleDetails;
}
