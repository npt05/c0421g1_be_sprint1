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
        return this.teacherRepository.findAllTeacher();
    }

    @Override
    public Teacher getById(Integer id) {
        return null;
    }

    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.createNewTeacher(teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherEmail(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(), teacher.getAccount().getAccountId(), teacher.getClassroom().getClassroomId(), teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId());
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Teacher> search(String search) {
        return null;
    }
}
