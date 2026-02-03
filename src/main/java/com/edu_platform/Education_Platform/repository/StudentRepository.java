package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAcademicYear(AcademicYear academicYear);
}