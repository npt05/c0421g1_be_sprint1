package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;

import java.util.List;

public interface IScheduleService {
    // Tai_NP coding day 22/10/2021
    List<ScheduleDetail> findScheduleDetailByClassId(Integer id);
}
