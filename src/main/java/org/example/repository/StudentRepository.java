package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndIsDeleteFalse(Long id);

    List<Student> findByAndIsDeleteFalse();
}
