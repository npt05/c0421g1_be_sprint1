package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping("student/search")
    public ResponseEntity<List<Student>> search(@RequestParam(defaultValue = "") Integer studentId,
                                                @RequestParam(defaultValue = "") String studentName,
                                                @RequestParam(defaultValue = "")Date studentDateOfBirth,
                                                @RequestParam(defaultValue = "") String classroom,
                                                @RequestParam(defaultValue = "") Double marks){
        List<Student> students = studentService.search(studentId,
                studentName, studentDateOfBirth, classroom, marks);
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
