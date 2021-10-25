package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher getById(Integer id) {
        return null;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Teacher> search(String search) {
        return null;
    }

    @Override
    public Page<Teacher> searchTeacher(Pageable pageable, String search) {
        return teacherRepository.searchTeacher(pageable, "%" + search + "%");
    }
//    @Override
//    public Page<Teacher> searchTeacher(Pageable pageable, Integer teacherId, String teacherName, Byte teacherGender, Date teacherDateOfBirth, String teacherPhone, String teacherAddress) {
//        return teacherRepository.searchTeacher(pageable, teacherId, "%"+teacherName+"%", teacherGender, teacherDateOfBirth, teacherPhone, teacherAddress);
//    }
}

