package com.codegym.service;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService extends GeneralService<Teacher, Integer>{
    Page<Teacher> findAllTeacherByQuery(Pageable pageable);
    Teacher findTeacherByIdByQuery(int id);
    Page<Teacher> findAllTeacherByQueryWithName(Pageable pageable, String name);
    Page<Teacher> findAllTeacherByQueryWithDivision(Pageable pageable, int id);
}
