package com.example.demoexceptions.controllers;

import com.example.demoexceptions.controllers.services.StudentService;
import com.example.demoexceptions.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<Course>>  retrieveCoursesForStudent(@PathVariable String studentId) {
        return  new ResponseEntity(studentService.retrieveCourses(studentId),HttpStatus.OK);
    }


}
