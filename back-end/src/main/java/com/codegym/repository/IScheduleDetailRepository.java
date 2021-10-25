package com.codegym.repository;

import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IScheduleDetailRepository extends JpaRepository<ScheduleDetail,Integer> {

    @Query(value="select sd.schedule_detail_id,sd.study_day_time_id,sd.subject_id,sd.schedule_id from schedule_detail sd \n" +
            "join schedule s on sd.schedule_id = s.schedule_id\n" +
            "join classroom cl on s.classroom_id = cl.classroom_id \n" +
            "join teacher t on cl.classroom_id = t.classroom_id where t.teacher_id =?1",nativeQuery=true)
    List<ScheduleDetail> getScheduleTeacher(@Param("id") Integer id);


}
