package com.codegym.rest_controller;

import com.codegym.dto.TeacherDTO;
import com.codegym.entity.about_teacher.Teacher;
import com.codegym.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    //DungNM - lấy ra danh sách giáo viên chưa có lớp
    @GetMapping("/teacher-no-classroom")
    public ResponseEntity<List<TeacherDTO>> getTeachersWithoutClassroom() {
        List<Teacher> teacherList = teacherService.getTeachersWithoutClassroom();
        System.err.println(teacherList.size());
        if (teacherList.size() > 0){
            List<TeacherDTO> teacherDTOList = new ArrayList<>();
            for (Teacher value: teacherList){
                TeacherDTO temp = new TeacherDTO();
                BeanUtils.copyProperties(value, temp);
                teacherDTOList.add(temp);
            }
            return new ResponseEntity<>(teacherDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
