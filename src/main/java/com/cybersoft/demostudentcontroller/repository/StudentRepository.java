package com.cybersoft.demostudentcontroller.repository;

import com.cybersoft.demostudentcontroller.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    List<StudentEntity> findByNameAndAge(String name, int age);

    @Query("from students as u where u.name = ?1 and u.age =?2 ")
    List<StudentEntity> getStudentNameAndAge(String name, int age);
}
