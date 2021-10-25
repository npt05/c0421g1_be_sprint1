package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService{
    List<Teacher>findAll();
    void save(Teacher teacher);
    Optional<Teacher> findById(int id);
    void delete(int id);

    void update(Teacher teacher);
}
