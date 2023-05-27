package com.cybersoft.demostudentcontroller.service;

import com.cybersoft.demostudentcontroller.entity.StudentEntity;
import com.cybersoft.demostudentcontroller.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class StudentService implements StudentServiceImp{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = studentRepository.findAll();
        return list;
    }

    @Override
    public List<StudentEntity> getStudentByNameAndAge(String name, int age) {
        return null;
    }

    @Override
    public StudentEntity addStudent(@RequestBody StudentEntity user) {
        StudentEntity newStudent = studentRepository.save(user);
        return newStudent;
    }

}
