package com.codegym.repository;

import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    //DanhNT coding for update teacher 00:00AM 23-10-2021
    @Query(value = "update teacher\n" +
            "set classroom_id = ?1 \n" +
            "where (teacher_id is null or teacher_id = ?2);" ,nativeQuery = true)
    Teacher updateClassForTeacher(Integer classId, Integer teacherId);
}
