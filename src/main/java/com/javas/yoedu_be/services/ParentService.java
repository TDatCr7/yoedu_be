package com.javas.yoedu_be.services;

import com.javas.yoedu_be.dto.parent.ParentResponse;
import com.javas.yoedu_be.dto.parent.ParentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<ParentResponse> findAll();
    Optional<ParentResponse> findById(Long id);
    ParentResponse create(ParentUpsertRequest parent);
    ParentResponse update(Long id, ParentUpsertRequest parent);
    void delete(Long id);
}
