package com.codegym.service;

import com.codegym.entity.about_schedule.Schedule;

import java.util.List;
public interface IScheduleService{

    List<Schedule> findAll();

    Schedule getById(Integer id);

    Schedule save(Schedule e);

    void delete(Integer id);

}
