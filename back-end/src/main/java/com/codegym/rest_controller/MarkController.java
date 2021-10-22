package com.codegym.rest_controller;

import com.codegym.entity.about_student.Mark;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/marks")
public class MarkController {

    @Autowired
    private IMarkService iMarkService;

    @GetMapping("/list")
    public ResponseEntity<List<Mark>> getAll() {
        List<Mark> markList = this.iMarkService.findAll();
        if (markList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(markList, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateMark(@RequestBody Mark mark) {
        this.iMarkService.save(mark);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
