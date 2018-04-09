package com.example.demoexceptions.controllers.services;

import com.example.demoexceptions.exception.ArithmeticExceptionCdpyme;
import com.example.demoexceptions.exception.StudentNotFoundException;
import com.example.demoexceptions.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService {
    @Override
    public List<Course> retrieveCourses(String studentId)  {

        if(studentId.equals("01")){

           throw new StudentNotFoundException("Courses not found");

        }
        else{
            doOperation();
          return getCourses();

        }

    }

    private double doOperation(){
        int a=4;
        int b=6;
        double result=0;
        try {
            result = a / 0;
        }catch (ArithmeticException ex){
            throw new ArithmeticExceptionCdpyme("division por cero","Validar dato de entrada",ex);
        }
        return result;

    }

    private  List<Course> getCourses(){
       List<Course> courses = new ArrayList<>();
       Course a = null;
       a.setId(1);
       a.setDescription("matematicas");
       Course b = new Course();
       b.setId(2);
       b.setDescription("Fisica");
       courses.add(a);
       courses.add(b);
    return courses;
    }
}
