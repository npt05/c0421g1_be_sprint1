package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    //Danh coding 2:00PM - 23-10-2021
    @Override
    public Student updateClassForStudent(Integer classId, Integer studentId) {
        return this.studentRepository.updateClassForStudent(classId, studentId);
    }
}
