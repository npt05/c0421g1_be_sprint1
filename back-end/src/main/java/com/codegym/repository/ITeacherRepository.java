package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(nativeQuery = true,
            value = "select " +
                    "teacher_id, delete_flag, teacher_address, teacher_date_of_birth, teacher_email, teacher_gender, teacher_image, teacher_name, teacher_phone, teacher_university, account_id, classroom_id, degree_id, division_id " +
                    "from teacher t " +
                    "where t.classroom_id IS NULL and t.delete_flag = false")
    List<Teacher> getTeachersWithoutClassroom();
}
