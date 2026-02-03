package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.StudentSubmission;
import com.edu_platform.Education_Platform.model.SubmissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubmissionRepository extends JpaRepository<StudentSubmission, Integer> {
    List<StudentSubmission> findByStudentId(Integer studentId);
    List<StudentSubmission> findByChallengeId(Integer challengeId);
    List<StudentSubmission> findByStudentIdAndChallengeId(Integer studentId, Integer challengeId);
    List<StudentSubmission> findByStatus(SubmissionStatus status);
}
