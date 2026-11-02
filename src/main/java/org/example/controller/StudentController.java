package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
       Student createdStudent =studentService.create(student);
        return ResponseEntity.status(201).body(createdStudent);

    }


}
