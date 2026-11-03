package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student create(Student student){
       Student repoStudent =studentRepository.save(student);
       return repoStudent;

    }

    public Student getStudent(Long id){
        Optional<Student> repoStudent = studentRepository.findByIdAndIsDeleteFalse(id);
        if(repoStudent.isPresent()){
            return repoStudent.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList =studentRepository.findByAndIsDeleteFalse();
         return studentList;

    }

    public  Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndIsDeleteFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setIsDelete(false);

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id){
      Boolean isStudent = studentRepository.existsById(id);
      if(!isStudent) return false;
      studentRepository.deleteById(id);
      return true;
    }

    public  Boolean deleteStudentSoftly(Long id){

        Optional<Student> existingStudent= studentRepository.findByIdAndIsDeleteFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setIsDelete(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
