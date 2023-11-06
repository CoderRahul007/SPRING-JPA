package com.SpringJPA.springdatajpa.repository;

import com.SpringJPA.springdatajpa.entity.Guardian;
import com.SpringJPA.springdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.lang.System.out;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudents(){
        Student student = Student.builder()
                .email("rahul.shukla@gmail.com")
                .firstName("Rahul")
                .lastName("Shukla")
                .build();
        studentRepository.save(student);
        out.println("Saved");
        List<Student> studentList = studentRepository.findAll();
        out.println(studentList);
    }

    @Test
    public void saveStudentsWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Suman")
                .email("suman@gmail.com")
                .build();
        Student student = Student.builder()
                .email("rahul.shukla@gmail.com")
                .firstName("Rahul")
                .lastName("Shukla")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
        out.println("Saved");
        List<Student> studentList = studentRepository.findAll();
        out.println(studentList);

    }

    @Test
    public  void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        out.println(studentList);
    }

}