package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
// Diep: search student
    @Query(value="select student.student_id, student_name, student_date_of_birth, grade_name  from student\n" +
            "join classroom on student.classroom_id = classroom.classroom_id \n" +
            "join mark on student.student_id = mark.student_id\n" +
            "join grade on classroom.classroom_id = grade.grade_id"
            , nativeQuery = true)
    List<Student> search(Integer studentId, String studentName, Date studentDateOfBirth,
                         String classroom, Double marks);
}
