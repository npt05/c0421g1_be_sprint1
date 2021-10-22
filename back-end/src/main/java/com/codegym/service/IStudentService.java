package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends GeneralService<Student, Integer>{
    Page<Student> findByClassroom(int classroomId, Pageable pageable);

}
