package com.javas.yoedu_be.dto.student;

import com.javas.yoedu_be.domain.enums.Gender;
import com.javas.yoedu_be.domain.enums.Status;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentUpsertRequest {
    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^HV\\d{3}$" )
    private String studentCode;

    @NotBlank
    @Size(max = 100)
    private String fullName;

    private LocalDate dateOfBirth;
    private Gender gender = Gender.OTHER;

    @Size(max = 50)
    private String gradeLevel;

    @Size(max = 200)
    private String schoolName;

    @Size(max = 20)
    private String phone;
    private Long parentId;
    private Status status = Status.ACTIVE;

    @DecimalMin("0.0")
    private BigDecimal latestScore = BigDecimal.ZERO;

    @Size(max = 500)
    private String note;
}
