package com.edu_platform.Education_Platform.services;

import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.model.Student;
import com.edu_platform.Education_Platform.repository.AcademicYearRepository;
import com.edu_platform.Education_Platform.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicYearService {

    @Autowired
    private AcademicYearRepository academicYearRepo;

    @Autowired
    private StudentRepository studentRepo;

    /**
     * Create Academic Year independently
     * Year can be created without programming languages
     * Languages and challenges will be added separately
     */
    @Transactional
    public AcademicYear createAcademicYear(AcademicYear year) {
        return academicYearRepo.save(year);
    }

    @Transactional(readOnly = true)
    public List<AcademicYear> getAllAcademicYear() {
        return academicYearRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AcademicYear> getAcademicYearById(Integer id) {
        return academicYearRepo.findById(id);
    }

    @Transactional
    public AcademicYear updateAcademicYear(Integer id, AcademicYear yearDetails) {
        return academicYearRepo.findById(id).map(year -> {
            year.setYear(yearDetails.getYear());
            return academicYearRepo.save(year);
        }).orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + id));
    }

    @Transactional
    public void deleteAcademicYear(Integer id) {
        AcademicYear year = academicYearRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + id));

        // Find all students linked to this year and remove the link
        List<Student> students = studentRepo.findByAcademicYear(year);
        for (Student student : students) {
            student.setAcademicYear(null);
            studentRepo.save(student);
        }

        // Now that no students are pointing to this year, we can safely delete it
        academicYearRepo.delete(year);
    }

    @Transactional(readOnly = true)
    public Integer getStudentCountForYear(Integer yearId) {
        AcademicYear year = academicYearRepo.findById(yearId)
                .orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + yearId));
        List<Student> students = studentRepo.findByAcademicYear(year);
        return students.size();
    }
}