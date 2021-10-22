package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IStudentService extends GeneralService<Student, Integer>{

//    Diệp search student ngày 22/10
List<Student> search(Integer studentId, String studentName, Date studentDateOfBirth,
                     String classroom, Double marks);


}
