package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/student")
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public String createStudent(@RequestBody Student student){
       studentService.create(student);
        return "student created";

    }
}
