package com.minsait.services;

import com.minsait.models.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);

    List<Course>findAllByTeacher(String teacher);
}
