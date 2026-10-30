package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CurdApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurdApplication.class, args);
        System.out.println("Sakshi");
    }
}