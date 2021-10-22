package com.codegym.service;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends GeneralService<Student, Integer> {

    List<Student> findAll();

    Student save(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name, String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion);

}
