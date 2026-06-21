package com.javas.yoedu_be.dto.course;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseResponse {
    private Long id;

    private String courseCode;

    private String name;

    private String description;

    private BigDecimal tuitionFee = BigDecimal.ZERO;

    private Integer totalSessions = 24;

    private Boolean isActive = true;
}
