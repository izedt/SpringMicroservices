package com.minsait.services;

import com.minsait.models.Course;
import com.minsait.responses.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);

    List<Course>findAllByTeacher(String teacher);
    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
