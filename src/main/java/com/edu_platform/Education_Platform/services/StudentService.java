package com.edu_platform.Education_Platform.services;

import com.edu_platform.Education_Platform.model.Student;
import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.repository.StudentRepository;
import com.edu_platform.Education_Platform.repository.AcademicYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private AcademicYearRepository academicYearRepo;

    /**
     * Add/Enroll student to an academic year
     */
    @Transactional
    public Student addStudent(Student studentRequest) {
        // Fetch AcademicYear from DB
        if (studentRequest.getAcademicYear() != null && studentRequest.getAcademicYear().getId() != null) {
            Optional<AcademicYear> yearOpt = academicYearRepo.findById(studentRequest.getAcademicYear().getId());
            if (yearOpt.isPresent()) {
                studentRequest.setAcademicYear(yearOpt.get());
            } else {
                throw new RuntimeException("AcademicYear not found with id " + studentRequest.getAcademicYear().getId());
            }
        } else {
            throw new RuntimeException("AcademicYear ID must be provided!");
        }

        // Set enrollment timestamp if not set
        if (studentRequest.getEnrolledAt() == null) {
            studentRequest.setEnrolledAt(LocalDateTime.now());
        }

        // Initialize stats
        if (studentRequest.getTotalChallengesSolved() == null) {
            studentRequest.setTotalChallengesSolved(0);
        }

        return studentRepo.save(studentRequest);
    }

    /**
     * Get student's curriculum (languages and challenges in their academic year)
     */
    @Transactional
    public AcademicYear getStudentCurriculum(Integer studentId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        if (studentOpt.isEmpty()) {
            throw new RuntimeException("Student not found with id " + studentId);
        }

        AcademicYear academicYear = studentOpt.get().getAcademicYear();

        // Force fetch of programmingLanguages and their challenges
        academicYear.getProgrammingLanguages().forEach(lang -> lang.getChallenges().size());

        return academicYear;
    }

    /**
     * Fetch all students
     */
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    /**
     * Fetch single student by ID
     */
    @Transactional
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    /**
     * Update student information
     */
    @Transactional
    public Student updateStudent(Integer id, Student studentDetails) {
        return studentRepo.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setRollNumber(studentDetails.getRollNumber());
            student.setLastActiveAt(LocalDateTime.now());
            return studentRepo.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    /**
     * Delete student
     */
    @Transactional
    public void deleteStudent(Integer id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepo.delete(student);
    }

    /**
     * Update student's last active timestamp
     */
    @Transactional
    public void updateLastActive(Integer studentId) {
        studentRepo.findById(studentId).ifPresent(student -> {
            student.setLastActiveAt(LocalDateTime.now());
            studentRepo.save(student);
        });
    }

    /**
     * Update total solved count
     */
    @Transactional
    public void incrementTotalSolved(Integer studentId) {
        studentRepo.findById(studentId).ifPresent(student -> {
            int current = student.getTotalChallengesSolved() != null ? student.getTotalChallengesSolved() : 0;
            student.setTotalChallengesSolved(current + 1);
            studentRepo.save(student);
        });
    }
}
