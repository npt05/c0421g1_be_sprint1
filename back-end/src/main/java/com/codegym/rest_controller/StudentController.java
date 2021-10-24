package com.codegym.rest_controller;

import com.codegym.dto.StudentDto;
import com.codegym.entity.about_student.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;


    //LamNT check list of student
    @GetMapping
    public ResponseEntity<List<Student>> showAll() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //LamNT do createStudent function
    @PostMapping("/add")
//    public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
//        this.studentService.saveStudent(student.isDeleteFlag(), student.getStudentAddress(),
//                student.getStudentDateOfBirth(), student.getStudentEthnicity(), student.getStudentFatherName(),
//                String.valueOf(student.getStudentGender()), student.getStudentMotherName(), student.getStudentName(),
//                student.getStudentParentPhone(), student.getStudentReligion());
//        return new ResponseEntity<>(student.getStudentId(), HttpStatus.CREATED);
//    }
    public ResponseEntity<Integer> addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.saveStudent(student);
        return new ResponseEntity<>(student.getStudentId(), HttpStatus.CREATED);
    }

    //LamNT do editStudent function
    @PutMapping("/edit")
    public ResponseEntity<?> editStudent(@RequestBody @Validated StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.editStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
