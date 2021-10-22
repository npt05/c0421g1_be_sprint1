package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins ="*")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;
    @GetMapping("/class")
    public ResponseEntity<List<Classroom>> getClassroomList() {
        List<Classroom> classroomList = classroomService.getClassroomList();
        if(classroomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.OK);
    }
}
