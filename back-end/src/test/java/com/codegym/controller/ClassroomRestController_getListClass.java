package com.codegym.controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.rest_controller.ClassroomController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ClassroomRestController_getListClass {
    @Autowired
    private ClassroomController classroomController;

    @Test
    public void getListStudent_5() {
        ResponseEntity<Page<Classroom>> pageResponseEntity
                = this.classroomController.showList(PageRequest.of(0, 5));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void getListStudent_6() {
        ResponseEntity<Page<Classroom>> pageResponseEntity
                = this.classroomController.showList(PageRequest.of(0, 5));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Classroom> classroomPage = pageResponseEntity.getBody();

        Assertions.assertEquals(5, classroomPage.getTotalElements());
        Assertions.assertEquals(5, classroomPage.getTotalPages());
    }
}
