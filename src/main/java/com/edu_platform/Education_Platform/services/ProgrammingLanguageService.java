package com.edu_platform.Education_Platform.services;

import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.model.ProgrammingLanguage;
import com.edu_platform.Education_Platform.repository.AcademicYearRepository;
import com.edu_platform.Education_Platform.repository.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguageRepository languageRepo;

    @Autowired
    private AcademicYearRepository academicYearRepo;

    /**
     * Create a programming language independently
     * Can be created without assigning to any year initially
     */
    @Transactional
    public ProgrammingLanguage createLanguage(ProgrammingLanguage language) {
        return languageRepo.save(language);
    }

    /**
     * Create programming language and assign to academic year
     */
    @Transactional
    public ProgrammingLanguage createLanguageForYear(Integer yearId, ProgrammingLanguage language) {
        AcademicYear year = academicYearRepo.findById(yearId)
                .orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + yearId));
        
        language.setAcademicYear(year);
        return languageRepo.save(language);
    }

    /**
     * Assign existing language to a year
     */
    @Transactional
    public ProgrammingLanguage assignLanguageToYear(Integer languageId, Integer yearId) {
        ProgrammingLanguage language = languageRepo.findById(languageId)
                .orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + languageId));
        
        AcademicYear year = academicYearRepo.findById(yearId)
                .orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + yearId));
        
        language.setAcademicYear(year);
        return languageRepo.save(language);
    }

    @Transactional(readOnly = true)
    public List<ProgrammingLanguage> getAllLanguages() {
        return languageRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ProgrammingLanguage> getLanguageById(Integer id) {
        return languageRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<ProgrammingLanguage> getLanguagesByYear(Integer yearId) {
        return languageRepo.findByAcademicYearId(yearId);
    }

    @Transactional(readOnly = true)
    public Optional<ProgrammingLanguage> getLanguageByName(String name) {
        return languageRepo.findByName(name);
    }

    @Transactional
    public ProgrammingLanguage updateLanguage(Integer id, ProgrammingLanguage languageDetails) {
        return languageRepo.findById(id).map(language -> {
            language.setName(languageDetails.getName());
            return languageRepo.save(language);
        }).orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + id));
    }

    @Transactional
    public void deleteLanguage(Integer id) {
        ProgrammingLanguage language = languageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + id));
        languageRepo.delete(language);
    }

    @Transactional(readOnly = true)
    public Integer getChallengeCountForLanguage(Integer languageId) {
        ProgrammingLanguage language = languageRepo.findById(languageId)
                .orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + languageId));
        return language.getChallenges() != null ? language.getChallenges().size() : 0;
    }
}
