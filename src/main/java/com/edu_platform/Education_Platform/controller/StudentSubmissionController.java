package com.edu_platform.Education_Platform.controller;

import com.edu_platform.Education_Platform.model.StudentChallengeProgress;
import com.edu_platform.Education_Platform.model.StudentSubmission;
import com.edu_platform.Education_Platform.model.SubmissionStatus;
import com.edu_platform.Education_Platform.services.StudentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin(origins = "*")
public class StudentSubmissionController {

    @Autowired
    private StudentSubmissionService submissionService;

    /**
     * Submit a solution for a challenge
     */
    @PostMapping("/student/{studentId}/challenge/{challengeId}")
    public ResponseEntity<StudentSubmission> submitSolution(
            @PathVariable Integer studentId,
            @PathVariable Integer challengeId,
            @RequestBody StudentSubmission submission) {
        StudentSubmission created = submissionService.submitSolution(studentId, challengeId, submission);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Get all submissions by a student
     */
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentSubmission>> getSubmissionsByStudent(@PathVariable Integer studentId) {
        List<StudentSubmission> submissions = submissionService.getSubmissionsByStudent(studentId);
        return ResponseEntity.ok(submissions);
    }

    /**
     * Get all submissions for a challenge
     */
    @GetMapping("/challenge/{challengeId}")
    public ResponseEntity<List<StudentSubmission>> getSubmissionsByChallenge(@PathVariable Integer challengeId) {
        List<StudentSubmission> submissions = submissionService.getSubmissionsByChallenge(challengeId);
        return ResponseEntity.ok(submissions);
    }

    /**
     * Get submissions by student and challenge
     */
    @GetMapping("/student/{studentId}/challenge/{challengeId}")
    public ResponseEntity<List<StudentSubmission>> getSubmissionsByStudentAndChallenge(
            @PathVariable Integer studentId,
            @PathVariable Integer challengeId) {
        List<StudentSubmission> submissions = submissionService.getSubmissionsByStudentAndChallenge(studentId, challengeId);
        return ResponseEntity.ok(submissions);
    }

    /**
     * Get submission by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentSubmission> getSubmissionById(@PathVariable Integer id) {
        return submissionService.getSubmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get submissions by status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<StudentSubmission>> getSubmissionsByStatus(@PathVariable SubmissionStatus status) {
        List<StudentSubmission> submissions = submissionService.getSubmissionsByStatus(status);
        return ResponseEntity.ok(submissions);
    }

    /**
     * Get challenge progress for a student
     */
    @GetMapping("/progress/student/{studentId}/challenge/{challengeId}")
    public ResponseEntity<StudentChallengeProgress> getProgressForChallenge(
            @PathVariable Integer studentId,
            @PathVariable Integer challengeId) {
        try {
            StudentChallengeProgress progress = submissionService.getProgressForChallenge(studentId, challengeId);
            return ResponseEntity.ok(progress);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get solved challenges by student
     */
    @GetMapping("/progress/student/{studentId}/solved")
    public ResponseEntity<List<StudentChallengeProgress>> getSolvedChallenges(@PathVariable Integer studentId) {
        List<StudentChallengeProgress> solved = submissionService.getSolvedChallenges(studentId);
        return ResponseEntity.ok(solved);
    }

    /**
     * Get total solved count for a student
     */
    @GetMapping("/progress/student/{studentId}/solved-count")
    public ResponseEntity<Map<String, Integer>> getTotalSolvedCount(@PathVariable Integer studentId) {
        Integer count = submissionService.getTotalSolvedCount(studentId);
        return ResponseEntity.ok(Map.of("totalSolved", count));
    }

    /**
     * Get student's accuracy rate
     */
    @GetMapping("/progress/student/{studentId}/accuracy")
    public ResponseEntity<Map<String, Double>> getStudentAccuracyRate(@PathVariable Integer studentId) {
        Double accuracy = submissionService.getStudentAccuracyRate(studentId);
        return ResponseEntity.ok(Map.of("accuracy", accuracy));
    }

    /**
     * Get accepted submission count for a challenge
     */
    @GetMapping("/challenge/{challengeId}/accepted-count")
    public ResponseEntity<Map<String, Integer>> getAcceptedSubmissionCount(@PathVariable Integer challengeId) {
        Integer count = submissionService.getAcceptedSubmissionCountForChallenge(challengeId);
        return ResponseEntity.ok(Map.of("acceptedCount", count));
    }

    /**
     * Delete submission
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Integer id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.noContent().build();
    }
}
