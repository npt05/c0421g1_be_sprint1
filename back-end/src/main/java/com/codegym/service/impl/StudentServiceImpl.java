package com.codegym.service.impl;

import com.codegym.entity.about_student.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student getById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student deleteById(int id) {
        Student student = getById(id);
        if (student != null) {
            studentRepository.deleteStudentById(id);
            return student;
        }else return null;
    }

    //DungNM - Tìm danh sách học sinh theo ID của classroom
    @Override
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return studentRepository.findByClassroomId(classroomId, pageable);
    }
}
