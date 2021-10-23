package com.codegym.rest_controller;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/schedule-detail/{classId}")
    public ResponseEntity<List<ScheduleDetail>> showScheduleTail(@PathVariable String classId){
        Integer id = Integer.parseInt(classId);
        List<ScheduleDetail> scheduleDetailList = this.scheduleService.findScheduleDetailByClassId(id);
        if (scheduleDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scheduleDetailList, HttpStatus.OK);
    }
}
