package com.minsait.controllers;


import com.minsait.models.Course;
import com.minsait.services.ICourseService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Course saveCourse(Course course){
       return courseService.save(course);
    }

    @GetMapping
    public ResponseEntity<?> findAllCourses(){
        return ResponseEntity.ok((courseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-by-teacher/{teacher}")
    public ResponseEntity<?> findByTeacher(@PathVariable String teacher){
        return ResponseEntity.ok(courseService.findAllByTeacher(teacher));
    }
}
