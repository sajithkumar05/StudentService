package com.microservice.services;


import com.microservice.model.School;
import com.microservice.model.Student;
import com.microservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student fetchStudentById(int id)
    {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())
        {
            return student.get();
        }else {
            return null;
        }
    }

    public List<Student> findAllStudent() {

        return studentRepository.findAll();
    }

    public Student fetchStudent(int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<School[]> responseEntity;
        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
        responseEntity = restTemplate.exchange("http://localhost:8081/service/school", HttpMethod.GET, entity, School[].class);



        return student;
    }
}
