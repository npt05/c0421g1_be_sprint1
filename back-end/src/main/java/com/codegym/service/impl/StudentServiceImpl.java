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
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(Integer id) {
        Student student = getById(id);
        if (student != null){
            student.setDeleteFlag(true);
            return save(student);
        }else return null;
    }

    @Override
    public List<Student> search(String search) {
        return null;
    }


    //DungNM - Tìm danh sách học sinh theo ID của classroom
    @Override
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return studentRepository.findByClassroomId(classroomId, pageable);
    }
}
