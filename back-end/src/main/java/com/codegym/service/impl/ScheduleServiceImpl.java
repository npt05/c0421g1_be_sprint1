package com.codegym.service.impl;

import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.repository.IScheduleRepository;
import com.codegym.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleDetail> findScheduleDetailByClassId(Integer id) {
        return scheduleRepository.findScheduleDetailByClassId(id);
    }
}
