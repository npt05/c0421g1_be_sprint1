package com.codegym.repository;

import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {

    // Tai_NP coding day 22/10/2021
    @Query(value = "select sd.schedule_detail_id, sd.study_day_time_id," +
            " sd.subject_id,  sd.schedule_id  from schedule_detail sd" +
            " join schedule s on sd.schedule_id = s.schedule_id" +
            " where  s.classroom_id = ?1", nativeQuery = true)
    List<ScheduleDetail> findScheduleDetailByClassId(Integer id);
}
