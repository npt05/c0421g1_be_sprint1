package com.codegym.repository;

import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IScheduleRepository extends JpaRepository<ScheduleDetail, Integer> {
    @Query(value = "select schedule_detail.schedule_detail_id, schedule_detail.study_day_time_id," +
            " schedule_detail.subject_id,  schedule_detail.schedule_id  from schedule_detail " +
            " join schedule  on schedule_detail.schedule_id = schedule.schedule_id" +
            " where  schedule.classroom_id = ?1" , nativeQuery = true)
    List<ScheduleDetail> findScheduleDetailByClassId(Integer id);

}
