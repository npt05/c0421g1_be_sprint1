package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.IClassroomService;
import com.codegym.service.IStudentService;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/classroom")
public class ClassroomController {

    //DanhNT coding controller
    @Autowired
    private IClassroomService classroomService;

    //DanhNT coding controller
    @Autowired
    private IStudentService studentService;

    //DanhNT coding controller
    @Autowired
    private ITeacherService teacherService;

    //DanhNT coding controller
    @GetMapping
    public ResponseEntity<List<Classroom>> showList() {
        List<Classroom> classroomList = this.classroomService.findAll();
        if (classroomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.OK);
    }

    //DanhNT coding controller
    @GetMapping("/get/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable Integer id) {
        Classroom classroom = this.classroomService.getById(id);
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    //DanhNT coding controller
    @PutMapping(value = "/edit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClass(@RequestBody Classroom classroom) {
         this.classroomService.
                updateSchoolYear(classroom.getClassroomSchoolYear(),classroom.getClassroomId());
//        Teacher editTeacher = this.teacherService.
//                updateClassForTeacher(teacher.getClassroom().getClassroomId(),teacher.getTeacherId());
//        Student editStudent = this.studentService.
//                updateClassForStudent(student.getClassroom().getClassroomId(),student.getStudentId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
