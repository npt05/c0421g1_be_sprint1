package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;

import java.util.List;

public interface IClassroomService{

    List<Classroom> findAll();

    Classroom getById(Integer id);

    Classroom save(Classroom e);

    void delete(Integer id);

    List<Classroom> search(String search);
}
