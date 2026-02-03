package com.edu_platform.Education_Platform.services;

import com.edu_platform.Education_Platform.model.*;
import com.edu_platform.Education_Platform.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentSubmissionService {

    @Autowired
    private StudentSubmissionRepository submissionRepo;

    @Autowired
    private StudentChallengeProgressRepository progressRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private ChallengesRepository challengesRepo;

    @Autowired
    private ChallengesService challengesService;

    /**
     * Submit a solution for a challenge
     */
    @Transactional
    public StudentSubmission submitSolution(Integer studentId, Integer challengeId, StudentSubmission submission) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Challenges challenge = challengesRepo.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id: " + challengeId));

        // Set student and challenge
        submission.setStudent(student);
        submission.setChallenge(challenge);
        submission.setSubmittedAt(LocalDateTime.now());

        // Save submission
        StudentSubmission savedSubmission = submissionRepo.save(submission);

        // Increment submission count
        challengesService.incrementSubmissionCount(challengeId);

        // Update progress
        updateProgressTracking(studentId, challengeId, submission.getStatus());

        return savedSubmission;
    }

    /**
     * Update the progress tracking for student-challenge
     */
    @Transactional
    private void updateProgressTracking(Integer studentId, Integer challengeId, SubmissionStatus status) {
        Optional<StudentChallengeProgress> progressOpt = progressRepo.findByStudentIdAndChallengeId(studentId, challengeId);

        StudentChallengeProgress progress;
        if (progressOpt.isPresent()) {
            progress = progressOpt.get();
            progress.setAttemptCount(progress.getAttemptCount() + 1);
        } else {
            progress = new StudentChallengeProgress();
            progress.setStudent(studentRepo.findById(studentId).orElseThrow());
            progress.setChallenge(challengesRepo.findById(challengeId).orElseThrow());
            progress.setAttemptCount(1);
            progress.setFirstAttemptAt(LocalDateTime.now());
            progress.setIsSolved(false);
        }

        // If accepted, mark as solved
        if (status == SubmissionStatus.ACCEPTED) {
            progress.setIsSolved(true);
            progress.setSolvedAt(LocalDateTime.now());
            if (progress.getFirstAttemptAt() != null) {
                long minutes = java.time.temporal.ChronoUnit.MINUTES.between(progress.getFirstAttemptAt(), LocalDateTime.now());
                progress.setSolvingTimeMinutes((int) minutes);
            }
            
            // Increment accepted count
            challengesService.incrementAcceptedCount(challengeId);
        }

        progressRepo.save(progress);
    }

    @Transactional(readOnly = true)
    public List<StudentSubmission> getSubmissionsByStudent(Integer studentId) {
        return submissionRepo.findByStudentId(studentId);
    }

    @Transactional(readOnly = true)
    public List<StudentSubmission> getSubmissionsByChallenge(Integer challengeId) {
        return submissionRepo.findByChallengeId(challengeId);
    }

    @Transactional(readOnly = true)
    public List<StudentSubmission> getSubmissionsByStudentAndChallenge(Integer studentId, Integer challengeId) {
        return submissionRepo.findByStudentIdAndChallengeId(studentId, challengeId);
    }

    @Transactional(readOnly = true)
    public Optional<StudentSubmission> getSubmissionById(Integer id) {
        return submissionRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<StudentSubmission> getSubmissionsByStatus(SubmissionStatus status) {
        return submissionRepo.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public StudentChallengeProgress getProgressForChallenge(Integer studentId, Integer challengeId) {
        return progressRepo.findByStudentIdAndChallengeId(studentId, challengeId)
                .orElseThrow(() -> new RuntimeException("No progress found for student " + studentId + " and challenge " + challengeId));
    }

    @Transactional(readOnly = true)
    public List<StudentChallengeProgress> getSolvedChallenges(Integer studentId) {
        return progressRepo.findByStudentIdAndIsSolvedTrue(studentId);
    }

    @Transactional(readOnly = true)
    public Integer getTotalSolvedCount(Integer studentId) {
        return getSolvedChallenges(studentId).size();
    }

    @Transactional(readOnly = true)
    public Double getStudentAccuracyRate(Integer studentId) {
        List<StudentChallengeProgress> allProgress = progressRepo.findByStudentId(studentId);
        List<StudentChallengeProgress> solved = progressRepo.findByStudentIdAndIsSolvedTrue(studentId);

        if (allProgress.isEmpty()) {
            return 0.0;
        }

        return (double) solved.size() / allProgress.size() * 100;
    }

    @Transactional(readOnly = true)
    public Integer getAcceptedSubmissionCountForChallenge(Integer challengeId) {
        List<StudentSubmission> submissions = submissionRepo.findByChallengeId(challengeId);
        return (int) submissions.stream()
                .filter(s -> s.getStatus() == SubmissionStatus.ACCEPTED)
                .count();
    }

    @Transactional
    public void deleteSubmission(Integer id) {
        StudentSubmission submission = submissionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found with id: " + id));
        submissionRepo.delete(submission);
    }
}
