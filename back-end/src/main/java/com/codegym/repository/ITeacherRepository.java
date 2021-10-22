package com.codegym.repository;

import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "insert into INSERT INTO `sprint1`.`teacher` ( `teacher_address`, `teacher_date_of_birth`, `teacher_email`, `teacher_gender`, `teacher_image`, `teacher_name`, `teacher_phone`, `teacher_university`, `account_id`, `classroom_id`, `degree_id`, `division_id`) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?11,?12); ",nativeQuery = true)
    void createNewTeacher(String address, Date dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university, Integer accountId, Integer classRoomId, Integer divisionId, Integer degreeId);

    @Query(value ="select * \n" +
            "from teacher",nativeQuery = true)
    List<Teacher> findAllTeacher();
}
