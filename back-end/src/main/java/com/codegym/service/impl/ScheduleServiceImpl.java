package com.codegym.service.impl;

import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.repository.IScheduleRepository;
import com.codegym.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleDetailRepository;


    @Override
    public List<ScheduleDetail> findScheduleDetailByClassId(Integer classId) {
        return this.scheduleDetailRepository.findScheduleDetailByClassId(classId);
    }


    @Override
    public List<ScheduleDetail> findAll() {
        return null;
    }

    @Override
    public ScheduleDetail getById(Integer id) {
        return null;
    }

    @Override
    public ScheduleDetail save(ScheduleDetail e) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ScheduleDetail> search(String search) {
        return null;
    }

}
