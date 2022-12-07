package com.enigma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public ResponseEntity getAllCourse(){
        return ResponseEntity.ok("Get all course");
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable("id") String id){
        return ResponseEntity.ok("Get course with id " + id);
    }
}
