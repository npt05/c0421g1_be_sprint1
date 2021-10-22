package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.service.IClassroomService;
import com.codegym.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {
    // QuanTA
    // Tiem Service
    @Autowired
    private IGradeService gradeService;

    @Autowired
    private IClassroomService classroomService;

    //api tra ve 1 list  grade
    @GetMapping(value = "/grades")
    public ResponseEntity<List<Grade>> showListGrade() {
        List<Grade> gradeList = this.gradeService.findAllGrade();
        if (gradeList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gradeList, HttpStatus.ACCEPTED);
    }

    // api tra ve 1 list classroom dang ton tai
    @GetMapping(value = "/classroom-exist")
    public ResponseEntity<List<Classroom>> showListClassroomExist() {
        List<Classroom> classroomList = this.classroomService.findAllClassroomExist();
        if (classroomList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.ACCEPTED);
    }





}
