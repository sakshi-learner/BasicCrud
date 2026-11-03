package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        student.setIsDelete(false);
       Student createdStudent =studentService.create(student);
        return ResponseEntity.status(201).body(createdStudent);

    }
    @GetMapping("/get")
    public  ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student student =studentService.getStudent(id);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return   ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList =studentService.getAllStudent();
        if(studentList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return   ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public  ResponseEntity<Student> updateStudent(@RequestParam Long id , @RequestBody Student studentReq){
        Student student =studentService.updateStudent(id,studentReq);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return   ResponseEntity.ok(student);


    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Permanantly Record Deleted !");
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDelete(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Record Deleted !");
    }

}
