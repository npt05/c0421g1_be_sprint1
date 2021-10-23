package com.codegym.rest_controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {

    @GetMapping("/test")
    public ResponseEntity<?> getTest(){
        return new ResponseEntity<>("LALAL", HttpStatus.OK);
    }
}
