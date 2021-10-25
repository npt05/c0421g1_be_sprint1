package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Teacher> getTeachersWithoutClassroom() {
        return teacherRepository.getTeachersWithoutClassroom();
    }
}
