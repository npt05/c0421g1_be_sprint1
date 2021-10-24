package com.codegym.rest_controller;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.service.IClassroomService;
import com.codegym.service.IGradeService;
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

    @Autowired
    private IGradeService gradeService;

    @Autowired
    private IClassroomService classroomService;

    // TaiNP 24/10/2021 method return list grade
    @GetMapping(value = "/grades")
    public ResponseEntity<List<Grade>> showListGrade() {
        List<Grade> grades = this.gradeService.findAll();
        if (grades == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(grades, HttpStatus.ACCEPTED);
    }

    // TaiNP 24/10/2021 method return list  class
    @GetMapping(value = "/classroom")
    public ResponseEntity<List<Classroom>> showListClass(){
        List<Classroom> classrooms = classroomService.findAll();
        if(classrooms.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    // TaiNP 24/10/2021 method return schedule of class_id
    @GetMapping("/schedule/{classId}")
    public ResponseEntity<List<ScheduleDetail>> showScheduleTail(@PathVariable(required = false) Integer classId){
        List<ScheduleDetail> scheduleDetailList = this.scheduleService.findScheduleDetailByClassId(classId);
        if (scheduleDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scheduleDetailList, HttpStatus.OK);
    }
}
