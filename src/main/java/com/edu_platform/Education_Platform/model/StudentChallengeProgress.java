package com.edu_platform.Education_Platform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_challenge_progress", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"student_id", "challenge_id"})
})
@EqualsAndHashCode(exclude = {"student", "challenge"})
@ToString(exclude = {"student", "challenge"})
public class StudentChallengeProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Challenges challenge;

    @Column(nullable = false)
    private Integer attemptCount;

    private Integer acceptedSubmissionId;

    @Column(nullable = false)
    private Boolean isSolved;

    @Column(nullable = false)
    private LocalDateTime firstAttemptAt;

    private LocalDateTime solvedAt;

    private Integer solvingTimeMinutes;
}
