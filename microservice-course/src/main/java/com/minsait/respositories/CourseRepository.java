package com.minsait.respositories;

import com.minsait.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findAllByTeacher(String teacher);
}
