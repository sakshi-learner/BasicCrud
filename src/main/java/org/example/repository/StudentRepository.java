package org.example.repository;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student save(Student student){
      Student s1 = new Student();
      return null;
    }
}
