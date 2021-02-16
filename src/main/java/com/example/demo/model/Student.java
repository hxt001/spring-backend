package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    @JsonProperty("address")
    private String city;

    public Student() {}


    public Student(String name, int age, String city) {
        this.setName(name);
        this.setAge(age);
        this.setCity(city);
    }

}
