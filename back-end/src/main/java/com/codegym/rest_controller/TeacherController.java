package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Division;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private final ITeacherService iTeacherService;

    public TeacherController(ITeacherService iTeacherService) {
        this.iTeacherService = iTeacherService;
    }

    @GetMapping("/listTeacher")
    public ResponseEntity<List<Teacher>> listAllTeacher() {
        List<Teacher> teachers = this.iTeacherService.findAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/newTeacher")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        this.iTeacherService.save(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
