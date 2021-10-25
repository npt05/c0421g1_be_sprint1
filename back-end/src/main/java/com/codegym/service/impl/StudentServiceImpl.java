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
        return null;
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
    public Page<Student> findSearch(Pageable pageable, String name, String status) {
        return studentRepository.findSearch(pageable,"%"+name+"%","%"+status+"%");
    }

//    @Override
//    public List<Student> findSearch(String name, String status) {
//        return studentRepository.findSearch("%"+name+"%","%"+status+"%");
//    }


}
