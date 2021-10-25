package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    // Diep search teacher 25/10
    @Autowired
    private ITeacherService teacherService;
    @GetMapping("/searchteacher")
    public ResponseEntity<Page<Teacher>> getsearchTeacher(@PageableDefault(value = 2) Pageable pageable, @RequestParam(required = false)String search)
//    )
//                                                          @RequestParam(required = false)Integer teacherId,
//                                                          @RequestParam(required = false) String teacherName,
//                                                          @RequestParam(required = false) Byte teacherGender,
//                                                          @RequestParam(required = false) Date teacherDateOfBirth,
//                                                          @RequestParam(required = false) String teacherPhone,
//                                                          @RequestParam(required = false)String teacherAddress,
                                                          {
//        Page<Teacher> teachers = teacherService.searchTeacher(pageable, teacherId, teacherName, teacherGender, teacherDateOfBirth, teacherPhone, teacherAddress);
        Page<Teacher> teachers = teacherService.searchTeacher(pageable, search);

        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}
