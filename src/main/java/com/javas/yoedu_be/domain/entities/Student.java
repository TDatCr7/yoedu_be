package com.javas.yoedu_be.domain.entities;

import com.javas.yoedu_be.domain.AuditableEntity;
import com.javas.yoedu_be.domain.enums.Gender;
import com.javas.yoedu_be.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(name = "student_code", nullable = false, unique = true, length = 20)
    private String studentCode;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender = Gender.OTHER;

    @Column(name = "grade_level", length = 30)
    private String gradeLevel;

    @Column(name = "school_name", length = 100)
    private String schoolName;

    @Column(length = 20)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACTIVE;

    @Column(name = "latest_score", precision = 5, scale = 2)
    private BigDecimal latestScore = BigDecimal.ZERO;

    @Column(length = 255)
    private String note;

}
