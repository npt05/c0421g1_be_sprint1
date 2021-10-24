package com.codegym.service;

import com.codegym.entity.about_classroom.Grade;


import java.util.List;

public interface IGradeService {
    List<Grade> findAll();

    Grade getById(Integer id);

    Grade save(Grade e);

    void delete(Integer id);

    List<Grade> search(String search);
}
