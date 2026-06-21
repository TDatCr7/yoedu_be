package com.javas.yoedu_be.dto.student;

import com.javas.yoedu_be.domain.enums.Gender;
import com.javas.yoedu_be.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record StudentResponse (
         Long id,
         String studentCode,
         String fullName,
         LocalDate dateOfBirth,
         Gender gender,
         String gradeLevel,
         String schoolName,
         String phone,
         Long parentId,
         String parentName,
         Status status,
         BigDecimal latestScore,
         String note,
         LocalDateTime createdAt,
         LocalDateTime updatedAt
){
}
