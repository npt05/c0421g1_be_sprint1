package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITeacherService extends GeneralService<Teacher, Integer>{





    List<ScheduleDetail> getScheduleTeacher( Integer id);
}
