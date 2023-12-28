package com.example.controllers;

import com.example.entity.Student;
import com.example.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        this.theStudents = List.of(
            new Student("John", "Doe"),
            new Student("Jane", "Doe"),
            new Student("Mary", "Public")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentErrorResponse(404, "Student not found", System.currentTimeMillis());
        }

        return theStudents.get(studentId);
    }
}
