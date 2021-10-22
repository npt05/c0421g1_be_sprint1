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
    // Diệp search student ngày 22/10
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

//// Nguyễn Văn A. Coding ngày 22/10
//    @GetMapping("/{classroomId}")
//    public ResponseEntity<Page<Student>> getStudentsOfClassroom(@PathVariable String classroomId,
//                                                                @PageableDefault(value = 10) Pageable pageable) {
//        try {
//            int classId = Integer.parseInt(classroomId);
//            Page<Student> students = studentService.findByClassroom(classId, pageable);
//            return new ResponseEntity<>(students, HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
////
//    @PostMapping("/add")
//    public ResponseEntity<Integer> addStudent() {
//        Classroom classroom = new Classroom();
//        Student student = new Student(1, (byte) 1,"a","a", null,"a","a","a","a","a","a","a",false, classroom, null);
//        Student newStudent = this.studentService.save(student);
//        return new ResponseEntity<>(newStudent.getStudentId(), HttpStatus.CREATED);
//    }
}
