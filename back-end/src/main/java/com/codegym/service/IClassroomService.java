package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;

import java.util.List;

public interface IClassroomService extends GeneralService<Classroom, Integer>{
    List<Classroom> getClassroomList();
}
