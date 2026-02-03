package com.edu_platform.Education_Platform.repository;

import com.edu_platform.Education_Platform.model.Challenges;
import com.edu_platform.Education_Platform.model.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengesRepository extends JpaRepository<Challenges, Integer> {
    List<Challenges> findByProgrammingLanguageId(Integer languageId);
    List<Challenges> findByDifficultyLevel(DifficultyLevel difficultyLevel);
    List<Challenges> findByProgrammingLanguageIdAndDifficultyLevel(Integer languageId, DifficultyLevel difficultyLevel);
    List<Challenges> findByIsActiveTrue();
    Challenges findByTitle(String title);
}
