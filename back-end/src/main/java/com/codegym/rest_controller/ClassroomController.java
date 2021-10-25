package com.codegym.rest_controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.IClassroomService;
import com.codegym.service.IStudentService;
import com.codegym.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    //DanhNT coding controller show list
    @GetMapping
    public ResponseEntity<Page<Classroom>> showList(@PageableDefault(value = 5) Pageable pageable) {
        Page<Classroom> classroomList = this.classroomService.findAllPage(pageable);
        if (classroomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classroomList, HttpStatus.OK);
    }

    //DanhNT coding controller find by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable Integer id) {
        Classroom classroom = this.classroomService.getById(id);
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    //DanhNT - coding controller for edit class information
    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClass(@RequestBody Classroom classroom) {
        Set<Student> studentList = classroom.getStudents();

        this.classroomService.updateSchoolYear(classroom.getClassroomSchoolYear(),
                classroom.getTeacher().getTeacherId(),
                classroom.getClassroomId());

        for (Student student : studentList) {
            this.studentService.updateClassForStudent(classroom.getClassroomId(), student.getStudentId());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DanhNT - coding controller for promote
    @PutMapping(value = "/promote/{id}")
    public ResponseEntity<?> promoteClass(@PathVariable Integer id) {
        Classroom classroom = this.classroomService.getById(id);
        Set<Student> studentSet = classroom.getStudents();
        for (Student student : studentSet) {
            Set<Mark> mark = student.getMarks();
            List<Double> avgList = new ArrayList<>();
            for (Mark m : mark) {
                avgList.add((m.getMarkPointNumber1() + m.getMarkPointNumber2() * 2 + m.getMarkPointNumber3() * 3) / 6);
            }
            Double avgMark = avgArray(avgList);
            if (avgMark < 3.5) {
                student.setStudentStatus(student.getClassroom().getClassroomName());
            }
            if (student.getClassroom().getGrade().getGradeId() == 1) {
                student.setClassroom(null);
            }


        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DanhNT - coding
    public Double avgArray(List<Double> arrayList) {
        double sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        return sum / arrayList.size();
    }
}
