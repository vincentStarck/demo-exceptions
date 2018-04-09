package com.example.demoexceptions.controllers.services;

import com.example.demoexceptions.model.Course;

import java.util.List;

public interface StudentService {
     List<Course> retrieveCourses(String studentId);
}
