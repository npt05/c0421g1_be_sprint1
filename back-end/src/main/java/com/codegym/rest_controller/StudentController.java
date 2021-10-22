package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/{classroomId}")
    public ResponseEntity<Page<Student>> getStudentsOfClassroom(@PathVariable String classroomId,
                                                                @PageableDefault(value = 10) Pageable pageable) {
        try {
            int classId = Integer.parseInt(classroomId);
            Page<Student> students = studentService.findByClassroom(classId, pageable);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
