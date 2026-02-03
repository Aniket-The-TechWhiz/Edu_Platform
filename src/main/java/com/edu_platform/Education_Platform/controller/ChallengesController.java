package com.edu_platform.Education_Platform.controller;

import com.edu_platform.Education_Platform.model.Challenges;
import com.edu_platform.Education_Platform.model.DifficultyLevel;
import com.edu_platform.Education_Platform.services.ChallengesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
@CrossOrigin(origins = "*")
public class ChallengesController {

    @Autowired
    private ChallengesService challengesService;

    /**
     * Create a challenge independently
     */
    @PostMapping
    public ResponseEntity<Challenges> createChallenge(@RequestBody Challenges challenge) {
        Challenges created = challengesService.createChallengeIndependent(challenge);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Create a challenge for a specific programming language
     */
    @PostMapping("/language/{languageId}")
    public ResponseEntity<Challenges> createChallengeForLanguage(
            @PathVariable Integer languageId,
            @RequestBody Challenges challenge) {
        Challenges created = challengesService.createChallenge(languageId, challenge);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Assign a challenge to a programming language
     */
    @PutMapping("/{challengeId}/assign-language/{languageId}")
    public ResponseEntity<Challenges> assignChallengeToLanguage(
            @PathVariable Integer challengeId,
            @PathVariable Integer languageId) {
        Challenges updated = challengesService.assignChallengeToLanguage(challengeId, languageId);
        return ResponseEntity.ok(updated);
    }

    /**
     * Get all challenges
     */
    @GetMapping
    public ResponseEntity<List<Challenges>> getAllChallenges() {
        List<Challenges> challenges = challengesService.getAllChallenges();
        return ResponseEntity.ok(challenges);
    }

    /**
     * Get challenge by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Challenges> getChallengeById(@PathVariable Integer id) {
        return challengesService.getChallengeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get challenges by programming language
     */
    @GetMapping("/language/{languageId}")
    public ResponseEntity<List<Challenges>> getChallengesByLanguage(@PathVariable Integer languageId) {
        List<Challenges> challenges = challengesService.getChallengesByLanguage(languageId);
        return ResponseEntity.ok(challenges);
    }

    /**
     * Get challenges by difficulty level
     */
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Challenges>> getChallengesByDifficulty(
            @PathVariable DifficultyLevel difficulty) {
        List<Challenges> challenges = challengesService.getChallengesByDifficulty(difficulty);
        return ResponseEntity.ok(challenges);
    }

    /**
     * Get challenges by language and difficulty
     */
    @GetMapping("/language/{languageId}/difficulty/{difficulty}")
    public ResponseEntity<List<Challenges>> getChallengesByLanguageAndDifficulty(
            @PathVariable Integer languageId,
            @PathVariable DifficultyLevel difficulty) {
        List<Challenges> challenges = challengesService.getChallengesByLanguageAndDifficulty(languageId, difficulty);
        return ResponseEntity.ok(challenges);
    }

    /**
     * Get active challenges
     */
    @GetMapping("/active")
    public ResponseEntity<List<Challenges>> getActiveChallenges() {
        List<Challenges> challenges = challengesService.getActiveChallenges();
        return ResponseEntity.ok(challenges);
    }

    /**
     * Update challenge
     */
    @PutMapping("/{id}")
    public ResponseEntity<Challenges> updateChallenge(
            @PathVariable Integer id,
            @RequestBody Challenges challengeDetails) {
        Challenges updated = challengesService.updateChallenge(id, challengeDetails);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete challenge
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Integer id) {
        challengesService.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Activate challenge
     */
    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activateChallenge(@PathVariable Integer id) {
        challengesService.activateChallenge(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Deactivate challenge
     */
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateChallenge(@PathVariable Integer id) {
        challengesService.deactivateChallenge(id);
        return ResponseEntity.ok().build();
    }
}
