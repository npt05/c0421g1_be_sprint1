package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.repository.ITeacherRepository;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;


    @Override
    public List<Teacher> findAll() {
      return null;
    }

    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.createNewTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(),teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId(),teacher.getClassroom().getClassroomId(),teacher.getAccount().getAccountId());
//        return this.teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return this.teacherRepository.findById(id);
    }

    @Override
    public void update(Teacher teacher) {
        this.teacherRepository.updateTeacher(teacher.isDeleteFlag(), teacher.getTeacherAddress(), teacher.getTeacherDateOfBirth(), teacher.getTeacherEmail(), teacher.getTeacherGender(), teacher.getTeacherImage(), teacher.getTeacherName(), teacher.getTeacherPhone(), teacher.getTeacherUniversity(),teacher.getDivision().getDivisionId(), teacher.getDegree().getDegreeId(),teacher.getClassroom().getClassroomId(),teacher.getAccount().getAccountId(),teacher.getTeacherId());
    }

    @Override
    public void delete(int id) {

    }
}
