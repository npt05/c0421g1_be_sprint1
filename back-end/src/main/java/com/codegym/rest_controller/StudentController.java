package com.codegym.rest_controller;

import com.codegym.entity.about_student.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    IStudentService iStudentService;
//    @GetMapping("/search")
//    public ResponseEntity<Page<Student>> searchByName(@PageableDefault(value = 1) Pageable pageable, @RequestParam String name, @RequestParam String status) {
//        Page<Student> studentList = iStudentService.findSearch(pageable,name,status);
//        if (studentList.isEmpty()) {
//            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(studentList,HttpStatus.OK);
//    }
@GetMapping("/search")
public ResponseEntity<List<Student>> searchByName( @RequestParam(defaultValue = "name") String name, @RequestParam("status") String status) {
    List<Student> studentList = iStudentService.findSearch(name,status);
    if (studentList.isEmpty()) {
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(studentList,HttpStatus.OK);
}
}
