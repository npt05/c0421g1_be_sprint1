package com.codegym.service;

import com.codegym.entity.about_student.Student;

import java.util.List;

public interface IStudentService{

    List<Student> findAll();

    Student getById(Integer id);

    Student save(Student e);

    void delete(Integer id);

    List<Student> search(String search);
}
