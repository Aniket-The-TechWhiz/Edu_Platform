package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.StudentChallengeProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentChallengeProgressRepository extends JpaRepository<StudentChallengeProgress, Integer> {
    List<StudentChallengeProgress> findByStudentId(Integer studentId);
    List<StudentChallengeProgress> findByChallengeId(Integer challengeId);
    Optional<StudentChallengeProgress> findByStudentIdAndChallengeId(Integer studentId, Integer challengeId);
    List<StudentChallengeProgress> findByStudentIdAndIsSolvedTrue(Integer studentId);
    List<StudentChallengeProgress> findByChallengeIdAndIsSolvedTrue(Integer challengeId);
}
