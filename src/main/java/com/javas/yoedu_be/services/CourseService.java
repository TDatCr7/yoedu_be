package com.javas.yoedu_be.services;


import com.javas.yoedu_be.dto.course.CourseResponse;
import com.javas.yoedu_be.dto.course.CourseUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseResponse> findAll();
    Optional<CourseResponse> findById(Long id);
    CourseResponse create(CourseUpsertRequest req);
    CourseResponse update(Long id, CourseUpsertRequest req);
    void delete(Long id);
}
