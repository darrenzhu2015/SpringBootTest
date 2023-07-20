package com.example.springboottest.dto;

public class StudentDTO {
    //add name, age, and grade fields
    private String name;
    private int age;
    private int grade;

    //add a new field called teacher with type TeacherDTO and add a getter and setter

    //add a new class TeacherDTO in the package com.example.springboottest.dto with name and age fields and a default constructor


    private TeacherDTO teacher;

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    //add a default constructor
    public StudentDTO() {
    }

    //add a constructor that takes in all fields
    public StudentDTO(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    //add getters and setters for all fields
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
