package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    //Danh coding 2:00PM - 23-10-2021
    @Override
    public Teacher updateClassForTeacher(Integer classId, Integer teacherId) {
        return this.teacherRepository.updateClassForTeacher(classId, teacherId);
    }
}
