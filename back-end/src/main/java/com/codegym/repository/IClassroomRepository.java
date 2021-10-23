package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
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
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.grade_id, t.teacher_name, c.delete_flag \n" +
            "from classroom c\n" +
            "join teacher t on t.classroom_id = c.classroom_id\n" +
            "where c.delete_flag = false;", nativeQuery = true)
    List<Classroom> findAllList();

    // DanhNT coding 5:00PM
    @Query(value = "select c.classroom_id, c.classroom_name, c.classroom_school_year, c.grade_id, t.teacher_name,c.delete_flag \n" +
            "from classroom c\n" +
            "join teacher t on t.classroom_id = c.classroom_id\n"+
            "where c.delete_flag = false and c.classroom_id = ?1", nativeQuery = true)
    Optional<Classroom> findById(Integer id);

    //DanhNT Coding for update class 11:30PM
    @Modifying
    @Transactional
    @Query(value = "update classroom set classroom_school_year = ?1 where classroom_id = ?2", nativeQuery = true)
    void updateSchoolYear(String schoolYear, Integer id);

}
