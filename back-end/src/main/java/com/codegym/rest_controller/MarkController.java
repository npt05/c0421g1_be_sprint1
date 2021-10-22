package com.codegym.rest_controller;

import com.codegym.entity.about_student.Mark;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class MarkController {
    @Autowired
    private IMarkService markService;
    @GetMapping("/mark")
    public ResponseEntity<List<Mark>> getMarkList() {
        List<Mark> markList = markService.getMarkList();
        if(markList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(markList, HttpStatus.OK);
    }
}
