package com.cybersoft.demostudentcontroller.controller;

import com.cybersoft.demostudentcontroller.entity.StudentEntity;
import com.cybersoft.demostudentcontroller.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<StudentEntity> studentEntity = new ArrayList<>();
    @Autowired
    StudentServiceImp studentServiceImp;


    @GetMapping("")
    public ResponseEntity<?> getAllStudent(){
        List<StudentEntity> list = studentServiceImp.getAllStudents();
        for (StudentEntity item : list) {
            System.out.println(item.getName());
            System.out.println(item.getAge());
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudentBody(
            @RequestBody StudentEntity student
    ){
        StudentEntity newStudent = studentServiceImp.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PostMapping("/student/{name}/{age}")
    public ResponseEntity<?> addStudentPathVariable(@PathVariable String name, @PathVariable int age, StudentEntity newStudent ) {
        newStudent.setName(name);
        newStudent.setAge(age);
        newStudent = studentServiceImp.addStudent(newStudent);
        return new ResponseEntity<>(newStudent,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudentRequestParam(@RequestParam("name") String name, @RequestParam("age") int age) {
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setAge(age);
        studentEntity.add(student);
        return new ResponseEntity<>(studentEntity,HttpStatus.OK);
    }
}
