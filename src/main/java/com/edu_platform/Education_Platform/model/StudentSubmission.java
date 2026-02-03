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
@Table(name = "student_submission")
@EqualsAndHashCode(exclude = {"student", "challenge"})
@ToString(exclude = {"student", "challenge"})
public class StudentSubmission {

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

    @Column(columnDefinition = "LONGTEXT")
    private String submittedCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubmissionStatus status; // SUBMITTED, ACCEPTED, WRONG_ANSWER, RUNTIME_ERROR, TIME_LIMIT_EXCEEDED

    private String testOutput;
    
    private String expectedOutput;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    private Integer executionTimeMs;

    private String language;
}
