package org.example.repository;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student save(Student student){
        System.out.println("enter in repo");
      Student s1 = new Student();
        s1.setName("Sakshi");
        s1.setAge(23);
        s1.setRollno(101);
        System.out.println("exit from repo");
      return s1;
    }
}
