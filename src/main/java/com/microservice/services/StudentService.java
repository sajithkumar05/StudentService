package com.microservice.services;

import com.microservice.model.Student;

import java.util.List;

public interface StudentService {

     Student save(Student student);
    //Student getAllStudent (String Id);
    List<Student> findAllStudent();

    Student fetchStudentById(int id);
}
