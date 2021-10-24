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
    public Page<Student> findByClassroom(int classroomId, Pageable pageable) {
        return null;
    }

    //LamNT saveStudent function
    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student.isDeleteFlag(), student.getStudentAddress(), student.getStudentDateOfBirth(),
                student.getStudentEthnicity(), student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(),
                student.getStudentName(), student.getStudentParentPhone(), student.getStudentReligion());
    }

//    @Override
//    public void saveStudent(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name, String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion) {
//        this.studentRepository.saveStudent(delete_flag, student_address, student_date_of_birth, student_ethnicity,
//        student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion);
//    }

    //LamNT editStudent function
    @Override
    public void editStudent(Student student) {
        studentRepository.editStudent(student.getStudentAddress(), student.getStudentDateOfBirth(), student.getStudentEthnicity(),
                student.getStudentFatherName(), String.valueOf(student.getStudentGender()), student.getStudentMotherName(), student.getStudentName(),
                student.getStudentParentPhone(), student.getStudentReligion(), student.getStudentId());
    }

//    @Override
//    public void editStudent(String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name, String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion) {
//        this.studentRepository.editStudent(student_address, student_date_of_birth, student_ethnicity, student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion);
//    }
}
