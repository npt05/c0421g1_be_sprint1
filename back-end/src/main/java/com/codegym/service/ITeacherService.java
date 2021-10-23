package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;

public interface ITeacherService {
   //Danh coding 2:00PM - 23-10-2021
   Teacher updateClassForTeacher(Integer classId,Integer teacherId);
}
