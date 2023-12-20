package com.minsait.controllers;

import com.minsait.models.Student;
import com.minsait.repositories.StudentRepository;
import com.minsait.services.IStudentService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(Student student){
        studentService.save(student);
    }

    @GetMapping
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok((studentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return  ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/search-by-id")
    public ResponseEntity<?> findByIdWithParam(@RequestParam Long id) {
        try {
            Student student = studentService.findById(id);
            return ResponseEntity.ok(student);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByCourse(idCourse));
    }


}
