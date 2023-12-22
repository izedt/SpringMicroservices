package com.minsait.services;

import com.minsait.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByCourse (Long idCourse);

}
