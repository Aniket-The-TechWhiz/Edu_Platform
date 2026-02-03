package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
    List<ProgrammingLanguage> findByAcademicYearId(Integer academicYearId);
    Optional<ProgrammingLanguage> findByName(String name);
    Optional<ProgrammingLanguage> findByNameAndAcademicYearId(String name, Integer academicYearId);
}
