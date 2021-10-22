package com.codegym.repository;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.entity.about_teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {


@Query(value="select * from teacher t join classroom c on t.classroom_id=c.classroom_id " +
        " join schedule s on s.classroom_id=c.classroom_id " +
        "join schedule_detail sd on sd.schedule_id=s.schedule_id " +
        "where  teacher_id=?1",nativeQuery=true)
    List<ScheduleDetail> getScheduleTeacher(@Param("id") Integer id);
}
