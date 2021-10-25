package com.codegym.DTO;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_schedule.ScheduleDetail;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ScheduleDto {
    private Integer scheduleId;
    private Classroom classroom;
    private boolean deleteFlag;
    private Set<ScheduleDetail> scheduleDetails;
}
