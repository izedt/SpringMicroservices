package com.minsait.services;

import com.minsait.DTO.StudentDTO;
import com.minsait.clients.StudentClient;
import com.minsait.models.Course;
import com.minsait.responses.StudentByCourseResponse;
import com.minsait.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

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

    @Override
    @Transactional(readOnly = true)
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        Course course = courseRepository.findById(idCourse).orElse(new Course());
        List<StudentDTO> studentDTOList = studentClient.findByIdCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
