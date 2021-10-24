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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Mark mark = this.iMarkService.getById(id);
        if (mark != null) {
            return new ResponseEntity<>(mark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateMark(@RequestBody Mark mark) {
        this.iMarkService.save(mark);
        return new ResponseEntity<>(mark,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchNameStudent(@RequestParam String nameStudent, String subject) {
        List<Mark> marks = this.iMarkService.search(nameStudent, subject);
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }
}
