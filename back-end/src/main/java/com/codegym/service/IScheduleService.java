package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;

import java.util.List;

public interface IScheduleService{

    List<ScheduleDetail> findAll();

    ScheduleDetail getById(Integer id);

    ScheduleDetail save(ScheduleDetail e);

    void delete(Integer id);

    List<ScheduleDetail> search(String search);

    List<ScheduleDetail> findScheduleDetailByClassId(Integer id);


}
