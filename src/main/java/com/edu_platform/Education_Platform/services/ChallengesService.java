package com.edu_platform.Education_Platform.services;

import com.edu_platform.Education_Platform.model.Challenges;
import com.edu_platform.Education_Platform.model.DifficultyLevel;
import com.edu_platform.Education_Platform.model.ProgrammingLanguage;
import com.edu_platform.Education_Platform.repository.ChallengesRepository;
import com.edu_platform.Education_Platform.repository.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengesService {

    @Autowired
    private ChallengesRepository challengesRepo;

    @Autowired
    private ProgrammingLanguageRepository languageRepo;

    /**
     * Create a challenge for a specific programming language
     */
    @Transactional
    public Challenges createChallenge(Integer languageId, Challenges challenge) {
        ProgrammingLanguage language = languageRepo.findById(languageId)
                .orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + languageId));
        
        challenge.setProgrammingLanguage(language);
        challenge.setCreatedAt(LocalDateTime.now());
        challenge.setIsActive(true);
        challenge.setAcceptedCount(0);
        challenge.setTotalSubmissions(0);
        
        return challengesRepo.save(challenge);
    }

    /**
     * Create challenge independently (without assigning to a language immediately)
     */
    @Transactional
    public Challenges createChallengeIndependent(Challenges challenge) {
        challenge.setCreatedAt(LocalDateTime.now());
        challenge.setIsActive(true);
        challenge.setAcceptedCount(0);
        challenge.setTotalSubmissions(0);
        
        return challengesRepo.save(challenge);
    }

    /**
     * Assign a challenge to a programming language
     */
    @Transactional
    public Challenges assignChallengeToLanguage(Integer challengeId, Integer languageId) {
        Challenges challenge = challengesRepo.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id: " + challengeId));
        
        ProgrammingLanguage language = languageRepo.findById(languageId)
                .orElseThrow(() -> new RuntimeException("Programming Language not found with id: " + languageId));
        
        challenge.setProgrammingLanguage(language);
        challenge.setUpdatedAt(LocalDateTime.now());
        
        return challengesRepo.save(challenge);
    }

    @Transactional(readOnly = true)
    public List<Challenges> getAllChallenges() {
        return challengesRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Challenges> getChallengeById(Integer id) {
        return challengesRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Challenges> getChallengesByLanguage(Integer languageId) {
        return challengesRepo.findByProgrammingLanguageId(languageId);
    }

    @Transactional(readOnly = true)
    public List<Challenges> getChallengesByDifficulty(DifficultyLevel difficultyLevel) {
        return challengesRepo.findByDifficultyLevel(difficultyLevel);
    }

    @Transactional(readOnly = true)
    public List<Challenges> getChallengesByLanguageAndDifficulty(Integer languageId, DifficultyLevel difficulty) {
        return challengesRepo.findByProgrammingLanguageIdAndDifficultyLevel(languageId, difficulty);
    }

    @Transactional(readOnly = true)
    public List<Challenges> getActiveChallenges() {
        return challengesRepo.findByIsActiveTrue();
    }

    @Transactional
    public Challenges updateChallenge(Integer id, Challenges challengeDetails) {
        return challengesRepo.findById(id).map(challenge -> {
            challenge.setTitle(challengeDetails.getTitle());
            challenge.setDescription(challengeDetails.getDescription());
            challenge.setProblemStatement(challengeDetails.getProblemStatement());
            challenge.setDifficultyLevel(challengeDetails.getDifficultyLevel());
            challenge.setTestCases(challengeDetails.getTestCases());
            challenge.setSampleInput(challengeDetails.getSampleInput());
            challenge.setSampleOutput(challengeDetails.getSampleOutput());
            challenge.setTimeLimit(challengeDetails.getTimeLimit());
            challenge.setMemoryLimit(challengeDetails.getMemoryLimit());
            challenge.setUpdatedAt(LocalDateTime.now());
            
            return challengesRepo.save(challenge);
        }).orElseThrow(() -> new RuntimeException("Challenge not found with id: " + id));
    }

    @Transactional
    public void deleteChallenge(Integer id) {
        Challenges challenge = challengesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id: " + id));
        challengesRepo.delete(challenge);
    }

    @Transactional
    public void activateChallenge(Integer id) {
        challengesRepo.findById(id).map(challenge -> {
            challenge.setIsActive(true);
            challenge.setUpdatedAt(LocalDateTime.now());
            return challengesRepo.save(challenge);
        }).orElseThrow(() -> new RuntimeException("Challenge not found with id: " + id));
    }

    @Transactional
    public void deactivateChallenge(Integer id) {
        challengesRepo.findById(id).map(challenge -> {
            challenge.setIsActive(false);
            challenge.setUpdatedAt(LocalDateTime.now());
            return challengesRepo.save(challenge);
        }).orElseThrow(() -> new RuntimeException("Challenge not found with id: " + id));
    }

    @Transactional
    public void incrementSubmissionCount(Integer challengeId) {
        challengesRepo.findById(challengeId).ifPresent(challenge -> {
            challenge.setTotalSubmissions((challenge.getTotalSubmissions() != null ? challenge.getTotalSubmissions() : 0) + 1);
            challengesRepo.save(challenge);
        });
    }

    @Transactional
    public void incrementAcceptedCount(Integer challengeId) {
        challengesRepo.findById(challengeId).ifPresent(challenge -> {
            challenge.setAcceptedCount((challenge.getAcceptedCount() != null ? challenge.getAcceptedCount() : 0) + 1);
            challengesRepo.save(challenge);
        });
    }
}
