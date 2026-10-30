package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student create(Student student){
        System.out.println("Enter in service");
       Student repoStudent =studentRepository.save(student);
        System.out.println("Exist from service");
     return repoStudent;

    }
}
