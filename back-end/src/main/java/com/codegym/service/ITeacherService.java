package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;

import java.util.List;

public interface ITeacherService extends GeneralService<Teacher, Integer>{

    List<Teacher> getTeachersWithoutClassroom();
}
