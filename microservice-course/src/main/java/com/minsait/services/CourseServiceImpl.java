package com.minsait.services;

import com.minsait.models.Course;
import com.minsait.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAllByTeacher(String teacher) {
        return courseRepository.findAllByTeacher(teacher);
    }
}
