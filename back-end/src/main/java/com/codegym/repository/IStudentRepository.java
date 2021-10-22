package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value="select " +
            "* " +
            "from student s where s.classroom_id = :id and s.delete_flag=false", nativeQuery = true)
    Page<Student> findByClassroomId(int id, Pageable pageable);

}
