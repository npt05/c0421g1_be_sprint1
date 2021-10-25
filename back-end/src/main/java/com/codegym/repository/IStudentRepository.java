package com.codegym.repository;

import com.codegym.entity.about_student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
//@Query(value="select * " +
//        "from student s inner join classroom c on s.classroom_id = c.classroom_id where s.student_name like :name " +
//        "and s.student_status like :status",nativeQuery=true)
//List<Student> findSearch(@Param("name") String name, @Param("status") String status);

    @Query(value="select * " +
            "from student s inner join classroom c on s.classroom_id = c.classroom_id where s.student_name like :name " +
            "and s.student_status like :status",nativeQuery=true)
    Page<Student> findSearch(Pageable pageable,@Param("name") String name, @Param("status") String status);
}
