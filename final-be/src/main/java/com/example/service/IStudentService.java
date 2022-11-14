package com.example.service;

import com.example.model.Classes;
import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);
}
