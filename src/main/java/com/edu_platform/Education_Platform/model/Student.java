package com.edu_platform.Education_Platform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EqualsAndHashCode(exclude = {"academicYear", "submissions", "progressTracking"})
@ToString(exclude = {"academicYear", "submissions", "progressTracking"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String rollNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    @JsonIgnoreProperties({"programmingLanguages", "hibernateLazyInitializer", "handler"})
    private AcademicYear academicYear;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("student")
    @Fetch(FetchMode.SUBSELECT)
    private Set<StudentSubmission> submissions;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("student")
    @Fetch(FetchMode.SUBSELECT)
    private Set<StudentChallengeProgress> progressTracking;

    @Column(nullable = false)
    private LocalDateTime enrolledAt;

    private LocalDateTime lastActiveAt;

    private Integer totalChallengesSolved;

    private Double averageScore;
}