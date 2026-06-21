package com.javas.yoedu_be.services;

import com.javas.yoedu_be.domain.entities.CourseClass;
import com.javas.yoedu_be.dto.course.CourseResponse;
import com.javas.yoedu_be.dto.courseclass.CourseClassCreateRequest;
import com.javas.yoedu_be.dto.courseclass.CourseClassResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseClassService {
    Page<CourseClassResponse> findAll(Pageable pageable);

    CourseClassResponse create(CourseClassCreateRequest request);
}
