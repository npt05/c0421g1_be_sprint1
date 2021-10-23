package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;

import java.util.List;

public interface ITeacherService{

    List<Teacher> findAll();

    Teacher getById(Integer id);

    Teacher save(Teacher e);

    void delete(Integer id);

    List<Teacher> search(String search);
}
