package com.codegym.repository;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {

    @Query(value = "sselect c.classroom_id, c.classroom_name, c.classroom_school_year, c.grade_id, t.teacher_name \n" +
            "from classroom c\n" +
            "join teacher t on t.classroom_id = c.classroom_id\n" +
            "where c.delete_flag = false;",nativeQuery = true)
    List<Classroom> findAllBy();
}
