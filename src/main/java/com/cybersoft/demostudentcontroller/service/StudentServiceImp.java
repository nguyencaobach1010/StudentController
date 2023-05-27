package com.cybersoft.demostudentcontroller.service;

import com.cybersoft.demostudentcontroller.entity.StudentEntity;

import java.util.List;

public interface StudentServiceImp {

    List<StudentEntity> getAllStudents();
    List<StudentEntity> getStudentByNameAndAge(String name, int age);
    StudentEntity addStudent(StudentEntity user);

}
