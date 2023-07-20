package com.example.springboottest.dto;

public class TeacherDTO {
    //add name and age fields
    private String name;
    private int age;

    //add a default constructor that takes in name and age

    public TeacherDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TeacherDTO() {
    }

    //add getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
