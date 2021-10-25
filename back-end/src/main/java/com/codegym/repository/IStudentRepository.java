package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    //DanhNT coding for edit class for student 11:30 PM 22-10-21
    @Modifying
    @Transactional
    @Query(value = "update student\n" +
            "set classroom_id = ?1\n" +
            "where student_id = ?2",nativeQuery = true)
    void updateClassForStudent(Integer classId,Integer studentId);
}
