package com.codegym.controller;

import com.codegym.dto.ClassroomDto;
import com.codegym.dto.TeacherDto;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.rest_controller.ClassroomController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClassroomRestController_editClass {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClassroomController classroomController;

    @Test
    public void editClass_name_19() throws Exception {
        ResponseEntity<Classroom> classroomResponseEntity = this.classroomController.findById(1);

        ClassroomDto classroomDto = new ClassroomDto();
        BeanUtils.copyProperties(classroomResponseEntity,classroomDto);
        classroomDto.setClassroomSchoolYear("");
        classroomDto.setClassroomName("");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/class-room/edit")
                .content(this.objectMapper.writeValueAsString(classroomDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_name_18() throws Exception {
        ResponseEntity<Classroom> classroomResponseEntity = this.classroomController.findById(1);

        ClassroomDto classroomDto = new ClassroomDto();
        BeanUtils.copyProperties(classroomResponseEntity,classroomDto);
        classroomDto.setClassroomSchoolYear("2021");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/studentRest/create")
                .content(this.objectMapper.writeValueAsString(classroomDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
