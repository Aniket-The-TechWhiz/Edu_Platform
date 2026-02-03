package com.edu_platform.Education_Platform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academic_year")
@EqualsAndHashCode(exclude = "programmingLanguages")
@ToString(exclude = "programmingLanguages")
public class AcademicYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "academic_year_name", nullable = false)
    private Year year;

    @OneToMany(mappedBy = "academicYear", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("academicYear")
    @Fetch(FetchMode.SUBSELECT)
    private Set<ProgrammingLanguage> programmingLanguages;
}