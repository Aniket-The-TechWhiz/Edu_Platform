package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Integer> {
    // Standard findAll() will now work without errors
}