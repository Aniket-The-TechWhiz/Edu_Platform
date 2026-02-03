package com.edu_platform.Education_Platform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "challenges")
@EqualsAndHashCode(exclude = "programmingLanguage")
@ToString(exclude = "programmingLanguage")
public class Challenges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String problemStatement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "programming_language_id", nullable = false)
    @JsonIgnoreProperties("challenges")
    private ProgrammingLanguage programmingLanguage;

    @Column(columnDefinition = "LONGTEXT")
    private String testCases; // JSON format with input and expected output

    @Column(columnDefinition = "LONGTEXT")
    private String sampleInput;

    @Column(columnDefinition = "LONGTEXT")
    private String sampleOutput;

    @Column(nullable = false)
    private Integer timeLimit; // in seconds

    @Column(nullable = false)
    private Integer memoryLimit; // in MB

    private Integer acceptedCount;

    private Integer totalSubmissions;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean isActive;
}