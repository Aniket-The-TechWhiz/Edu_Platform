package com.edu_platform.Education_Platform.controller;

import com.edu_platform.Education_Platform.model.Student;
import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    /**
     * Create/Enroll a new student
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student studentRequest) {
        Student savedStudent = service.addStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    /**
     * Get all students
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Get student by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = service.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    /**
     * Get student's curriculum (languages and challenges for their year)
     */
    @GetMapping("/{id}/curriculum")
    public ResponseEntity<AcademicYear> viewCurriculum(@PathVariable Integer id) {
        AcademicYear curriculum = service.getStudentCurriculum(id);
        return ResponseEntity.ok(curriculum);
    }

    /**
     * Update student information
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Integer id,
            @RequestBody Student studentDetails) {
        Student updated = service.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete student
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return ResponseEntity.ok(Map.of("message", "Student deleted successfully"));
    }
}

