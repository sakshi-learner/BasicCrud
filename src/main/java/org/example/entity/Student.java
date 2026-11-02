package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Student {
    @Id
    private long id ;
    private String name;
    private String email;
    private int rollNo;
    private int age;
    private String subject;

}
