package org.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Student {
    @Id
    private long id ;
    private String name;
    private int rollno;
    private int age;
}
