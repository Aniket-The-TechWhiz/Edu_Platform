package com.edu_platform.Education_Platform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programming_language")
@EqualsAndHashCode(exclude = {"academicYear", "challenges"}) // FIXES STACKOVERFLOW
@ToString(exclude = {"academicYear", "challenges"})
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    @JsonIgnoreProperties("programmingLanguages")
    private AcademicYear academicYear;

    @OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("programmingLanguage")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Challenges> challenges;
}