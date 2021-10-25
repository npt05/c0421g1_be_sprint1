package com.codegym.repository;

import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    @Modifying
    @Query(value = "insert into teacher (delete_flag,teacher_address,teacher_date_of_birth,teacher_email,teacher_gender,teacher_image,teacher_name,teacher_phone,teacher_university,degree_id,division_id,classroom_id,account_id)\n" +
            "value(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13);",nativeQuery = true)
    void createNewTeacher(Boolean deleteFlag,String address, Date dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university,Integer divisionId, Integer degreeId, Integer classrommId,Integer account_id);

//    @Query(value = "select teacher_id,delete_flag,teacher_address,teacher_date_of_birth,teacher_email,teacher_gender,teacher_image,teacher_name,teacher_phone,teacher_university,degree_id,division_id,classroom_id,account_id\n" +
//            "from teacher \n" +
//            "where teacher_id = ? ;",nativeQuery = true)
//

//    @Query(value = "update teacher set delete_flag = ?1,teacher_address = ?2,teacher_date_of_birth= ?3,teacher_email = ?4,teacher_gender=?5,teacher_image=?6,teacher_name=?7,teacher_phone=?8,teacher_university=?9,degree_id=?10,division_id=?11,classroom_id=?12,account_id = ?13\n" +
//            "where teacher_id = ?14;",nativeQuery = true)
//    void updateTeacher(Boolean deleteFlag,String address, Date dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university,Integer divisionId, Integer degreeId, Integer classrommId,Integer account_id,int id);


    @Modifying
    @Query(value = "update teacher set delete_flag = ?1,teacher_address = ?2,teacher_date_of_birth= ?3,teacher_email = ?4,teacher_gender=?5,teacher_image=?6,teacher_name=?7,teacher_phone=?8,teacher_university=?9,degree_id=?10,division_id=?11,classroom_id=?12,account_id = ?13 \n" +
            "where (teacher_id = ?14);",nativeQuery = true)
    void updateTeacher(Boolean deleteFlag,String address, Date dateOfBirth, String email, Byte gender, String image, String name, String phone, String teacher_university,Integer divisionId, Integer degreeId, Integer classrommId,Integer accouuntId,Integer teacherId);
}
