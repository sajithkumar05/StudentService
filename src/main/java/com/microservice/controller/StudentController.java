package com.microservice.controller;

import com.microservice.model.Student;
import com.microservice.repository.StudentRepository;
import com.microservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@RestController
@RequestMapping(value="/service")
public class StudentController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }


    //get student
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudent(){
        return studentService.findAllStudent();
    }

    //save student
    @RequestMapping(value = "/student",method= RequestMethod.POST)
    public Student save(@RequestBody Student student)
    {

        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
        Student student = studentService.fetchStudentById(id);
            if(student==null)
            {
                return ResponseEntity.notFound().build();
            }
            else {
               return ResponseEntity.ok().body(student);
            }

    }




}
