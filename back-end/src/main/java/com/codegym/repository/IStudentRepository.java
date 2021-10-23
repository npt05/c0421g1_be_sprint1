package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    //DanhNT coding for update Class 11:30 PM 22-10-21
    @Query(value = "update student\n" +
            "set classroom_id = ?1 \n" +
            "where (student_id is null or student_id = ?2);",nativeQuery = true)
    Student updateClassForStudent(Integer classId,Integer studentId);
}
