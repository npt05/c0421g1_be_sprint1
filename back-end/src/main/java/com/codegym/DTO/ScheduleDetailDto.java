package com.codegym.DTO;

import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_schedule.StudyDayTime;
import com.codegym.entity.about_schedule.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetailDto {

    @NotBlank (message = "Vui lòng chọn môn học")
    private Integer scheduleDetailId;
    @NotBlank (message = "Vui lòng chọn môn học")
    private SubjectDto subject;
    @NotBlank (message = "Vui lòng chọn môn học")
    private StudyDayTimeDto studyDayTime;
    @NotBlank (message = "Vui lòng chọn môn học")
    private ScheduleDto schedule;
}
