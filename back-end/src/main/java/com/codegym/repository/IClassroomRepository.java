package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {

    // DanhNT coding 5:00PM
    @Modifying
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
            "from classroom c\n" +
            "join teacher t on t.teacher_id = c.teacher_id\n" +
            "where c.delete_flag = false;", nativeQuery = true)
    List<Classroom> findAllList();

    // DanhNT coding 5:00PM
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
            "from classroom c\n" +
            "join teacher t on t.teacher_id = c.teacher_id\n" +
            "where c.delete_flag = false and c.classroom_id = ?1 ;", nativeQuery = true)
    Optional<Classroom> findById(Integer id);

    //DanhNT Coding for update class 11:30PM
    @Modifying
    @Transactional
    @Query(value = "update classroom \n" +
            "set classroom_school_year = ?1, teacher_id = ?2\n" +
            "where classroom_id = ?3", nativeQuery = true)
    void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId);

    //DanhNT coding find all list class pagination
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.delete_flag, c.grade_id, c.teacher_id\n" +
            "from classroom c\n" +
            "join teacher t on t.teacher_id = c.teacher_id\n" +
            "where c.delete_flag = false",
            countQuery = "select count(*)\n" +
                    "from classroom c \n" +
                    "join teacher t on t.teacher_id = c.teacher_id\n" +
                    "where c.delete_flag = false"
            ,nativeQuery = true)
    Page<Classroom> findAllPage(Pageable pageable);

}
