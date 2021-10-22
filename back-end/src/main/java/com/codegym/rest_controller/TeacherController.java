package com.codegym.rest_controller;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    @GetMapping("/list")
    public ResponseEntity<Page<Teacher>> getTeacherList
            (@PageableDefault(value = 1, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Teacher>teacherList = teacherService.findAllTeacherByQuery(pageable);
        if (teacherList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }
    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.delete(id);
    }
}
