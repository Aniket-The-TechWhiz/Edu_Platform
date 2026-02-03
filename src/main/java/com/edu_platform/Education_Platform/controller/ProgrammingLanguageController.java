package com.edu_platform.Education_Platform.controller;

import com.edu_platform.Education_Platform.model.ProgrammingLanguage;
import com.edu_platform.Education_Platform.services.ProgrammingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin(origins = "*")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageService languageService;

    /**
     * Create a programming language independently
     */
    @PostMapping
    public ResponseEntity<ProgrammingLanguage> createLanguage(@RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage created = languageService.createLanguage(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Create a programming language and assign to academic year
     */
    @PostMapping("/year/{yearId}")
    public ResponseEntity<ProgrammingLanguage> createLanguageForYear(
            @PathVariable Integer yearId,
            @RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage created = languageService.createLanguageForYear(yearId, language);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Assign existing language to a year
     */
    @PutMapping("/{languageId}/assign-year/{yearId}")
    public ResponseEntity<ProgrammingLanguage> assignLanguageToYear(
            @PathVariable Integer languageId,
            @PathVariable Integer yearId) {
        ProgrammingLanguage updated = languageService.assignLanguageToYear(languageId, yearId);
        return ResponseEntity.ok(updated);
    }

    /**
     * Get all languages
     */
    @GetMapping
    public ResponseEntity<List<ProgrammingLanguage>> getAllLanguages() {
        List<ProgrammingLanguage> languages = languageService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }

    /**
     * Get language by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> getLanguageById(@PathVariable Integer id) {
        return languageService.getLanguageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get languages by academic year
     */
    @GetMapping("/year/{yearId}")
    public ResponseEntity<List<ProgrammingLanguage>> getLanguagesByYear(@PathVariable Integer yearId) {
        List<ProgrammingLanguage> languages = languageService.getLanguagesByYear(yearId);
        return ResponseEntity.ok(languages);
    }

    /**
     * Get language by name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<ProgrammingLanguage> getLanguageByName(@PathVariable String name) {
        return languageService.getLanguageByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update language
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> updateLanguage(
            @PathVariable Integer id,
            @RequestBody ProgrammingLanguage languageDetails) {
        ProgrammingLanguage updated = languageService.updateLanguage(id, languageDetails);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete language
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get challenge count for a language
     */
    @GetMapping("/{languageId}/challenge-count")
    public ResponseEntity<Map<String, Integer>> getChallengeCount(@PathVariable Integer languageId) {
        Integer count = languageService.getChallengeCountForLanguage(languageId);
        return ResponseEntity.ok(Map.of("challengeCount", count));
    }
}
