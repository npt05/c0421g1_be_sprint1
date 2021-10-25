package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Division;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
    @RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private final ITeacherService iTeacherService;

    public TeacherController(ITeacherService iTeacherService) {
        this.iTeacherService = iTeacherService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> listAllTeacher() {
        List<Teacher> teachers = this.iTeacherService.findAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        this.iTeacherService.save(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> getIdTeacher(@PathVariable int id) {
        Optional<Teacher> optionalTeacher = this.iTeacherService.findById(id);
        return new ResponseEntity(optionalTeacher, HttpStatus.OK);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PATCH)
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
        this.iTeacherService.update(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
