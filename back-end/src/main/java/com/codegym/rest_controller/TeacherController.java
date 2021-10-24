package com.codegym.rest_controller;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

//    MinhNN 24/10 find teacher by id account
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Teacher teacher = iTeacherService.getById(id);
        if (teacher != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(teacher,HttpStatus.OK);
        }
    }

//    MinhNN 24/10 update infor teacher
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInforTeacher(@RequestBody Teacher teacher, Account account) {
        iTeacherService.update(teacher, account.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
