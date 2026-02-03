package com.edu_platform.Education_Platform.controller;

import com.edu_platform.Education_Platform.model.AcademicYear;
import com.edu_platform.Education_Platform.services.AcademicYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/academic-year")
@CrossOrigin(origins = "*")
public class AcademicYearController {

    @Autowired
    private AcademicYearService service;

    /**
     * Create a new academic year independently
     * Languages and challenges will be added separately
     */
    @PostMapping
    public ResponseEntity<AcademicYear> createAcademicYear(@RequestBody AcademicYear academicYear) {
        AcademicYear created = service.createAcademicYear(academicYear);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Get all academic years
     */
    @GetMapping
    public ResponseEntity<List<AcademicYear>> getAll() {
        List<AcademicYear> years = service.getAllAcademicYear();
        return ResponseEntity.ok(years);
    }

    /**
     * Get academic year by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<AcademicYear> getAcademicYearById(@PathVariable Integer id) {
        return service.getAcademicYearById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update academic year
     */
    @PutMapping("/{id}")
    public ResponseEntity<AcademicYear> updateAcademicYear(
            @PathVariable Integer id,
            @RequestBody AcademicYear yearDetails) {
        AcademicYear updated = service.updateAcademicYear(id, yearDetails);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete academic year
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAcademicYear(@PathVariable Integer id) {
        service.deleteAcademicYear(id);
        return ResponseEntity.ok(Map.of("message", "Academic Year deleted successfully"));
    }

    /**
     * Get student count for a year
     */
    @GetMapping("/{id}/student-count")
    public ResponseEntity<Map<String, Integer>> getStudentCount(@PathVariable Integer id) {
        Integer count = service.getStudentCountForYear(id);
        return ResponseEntity.ok(Map.of("studentCount", count));
    }
}
