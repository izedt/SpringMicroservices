package com.minsait.services;

import com.minsait.models.Student;
import com.minsait.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>)  studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true) //Los de consulta no llevan readonly
    public List<Student> findByCourse(Long idCourse) {
        return studentRepository.findAllByCourseId(idCourse);
    }
}
