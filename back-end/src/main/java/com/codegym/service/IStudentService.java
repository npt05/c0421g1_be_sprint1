package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;


public interface IStudentService extends GeneralService<Student, Integer>{



    Page<Student> getListStudent(Pageable pageable,Integer id);


    Optional<Student> getListStudentDetail(Integer id);
}
