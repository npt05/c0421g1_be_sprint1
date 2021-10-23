package com.codegym.service;

import com.codegym.entity.about_student.Student;

public interface IStudentService{
    //Danh coding 2:00PM - 23-10-2021
    Student updateClassForStudent(Integer classId, Integer studentId);
}
