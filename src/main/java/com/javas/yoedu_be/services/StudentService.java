package com.javas.yoedu_be.services;

import com.javas.yoedu_be.dto.student.StudentResponse;
import com.javas.yoedu_be.dto.student.StudentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<StudentResponse> findAll();

    Optional<StudentResponse> findById(Long id);

    StudentResponse create(StudentUpsertRequest reg);
    StudentResponse update(Long id, StudentUpsertRequest reg);

    void delete(Long id);
}
