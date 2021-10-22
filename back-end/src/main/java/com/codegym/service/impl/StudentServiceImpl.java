package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<Student> search(String search) {
        return null;
    }


    @Override
    public Student save(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name, String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion) {
        return studentRepository.saveStudent(delete_flag, student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion);
    }
}
