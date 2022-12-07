package com.enigma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("courses")
public class CourseController {
    @GetMapping
    public ResponseEntity getAllCourse(@RequestHeader(name="my-header", required = false) String header){
        System.out.println(header);
        if(header == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is null");
        }
        if(header.equals("123")){
            return ResponseEntity.ok("get all course");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable("id") String id, @RequestHeader Map<String, String> headers){
//        if(getAllCourse(headers.get(headers)).getStatusCode().equals(HttpStatus.UNAUTHORIZED)){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
//        }
        for(String headerName : headers.keySet()){
            System.out.println("key : " + headerName + " " + headers.get(headerName));
        }
        return ResponseEntity.ok("Get course with id " + id);
    }
}
