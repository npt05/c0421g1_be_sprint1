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

    //chuc nang hien thi danh sach giao vien - LinhDN
    @GetMapping("/list")
    public ResponseEntity<Page<Teacher>> getTeacherList
    (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQuery(pageable);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }

    //chuc nang chon 1 giao vien - LinhDN
    @GetMapping("{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable int id) {
        Teacher teacher = teacherService.findTeacherByIdByQuery(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //chuc nang xoa 1 giao vien (thuc chat la update teacher_deleteFlag = 1) - LinhDN
    @PutMapping("delete/{id}")
    public void deleteTeacherById(@PathVariable int id) {
        teacherService.delete(id);
    }

    //chuc nang tim kiem theo ten  - LinhDN
    @GetMapping("/list/search")
    public ResponseEntity<Page<Teacher>> getTeacherListWithKeyWord
    (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam("name") String name) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQueryWithName(pageable, name);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }

    //chuc nang tim kiem theo phong ban  - LinhDN
    @GetMapping("/list/division/{id}")
    public ResponseEntity<Page<Teacher>> getTeacherListByDivision
            (@PageableDefault(value = 2, sort = "teacher_id", direction = Sort.Direction.ASC) Pageable pageable,@PathVariable int id) {
        Page<Teacher> teacherList = teacherService.findAllTeacherByQueryWithDivision(pageable, id);
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        }
    }
}
