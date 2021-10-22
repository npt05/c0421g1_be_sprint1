package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.classroom.classroomId = :id and s.deleteFlag=false ")
    Page<Student> findByClassroomId(int id, Pageable pageable);

    @Modifying
    @Query(value = "insert into `sprint1`.`student` (delete_flag,student_address, student_date_of_birth, student_ethnicity," +
            "student_father_name, student_gender, student_mother_name, student_name, student_parent_phone, student_religion) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    Student saveStudent(boolean delete_flag, String student_address, String student_date_of_birth, String student_ethnicity, String student_father_name,
                        String student_gender, String student_mother_name, String student_name, String student_parent_phone, String student_religion);
}
