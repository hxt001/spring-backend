package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/test1")
    public List<Student> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        List<Student> list = studentRepository.findByName("jialiu2");
//        list.add(new Student("lei", 20, "menlo park"));
//        list.add(new Student("teng", 30, "LA"));
        return list;
    }

    @GetMapping("/updatestudent")
    public List<Student> updateage(@RequestParam(value = "name", defaultValue = "World") String name1,
            @RequestParam(value = "age", defaultValue = "0") String age) {

        int ageInt = Integer.parseInt(age);
        List<Student> list = studentRepository.findByName(name1);
        for (Student s :list) {
            s.setAge(ageInt);
        }
        studentRepository.saveAll(list);
//        list.add(new Student("lei", 20, "menlo park"));
//        list.add(new Student("teng", 30, "LA"));
        return list;
    }

    @GetMapping("/test2")
    public Student test2(@RequestParam(value = "name", defaultValue = "World") String name1,
                         @RequestParam(value = "age", defaultValue = "0") String age) {
        int ageInt = Integer.parseInt(age);
        Student stu1 = new Student(name1, ageInt, "menlo park");
        studentRepository.save(stu1);
        return stu1;
    }

    @GetMapping("/add")
    public String add(@RequestParam(value = "op1", defaultValue = "0") String op1,
                           @RequestParam(value = "op2", defaultValue = "0") String op2) {
        return Integer.toString(Integer.parseInt(op1) + Integer.parseInt(op2));
    }
}
