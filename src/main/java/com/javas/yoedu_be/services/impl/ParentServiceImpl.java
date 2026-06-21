package com.javas.yoedu_be.services.impl;

import com.javas.yoedu_be.domain.entities.Parent;
import com.javas.yoedu_be.dto.parent.ParentResponse;
import com.javas.yoedu_be.dto.parent.ParentUpsertRequest;
import com.javas.yoedu_be.repositories.ParentRepository;
import com.javas.yoedu_be.services.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    private Parent toParent(ParentUpsertRequest req) {
        return modelMapper.map(req, Parent.class);
    }

    private ParentResponse toParentResponse(Parent parent) {
        return modelMapper.map(parent, ParentResponse.class);
    }

    @Override
    public List<ParentResponse> findAll() {
        return parentRepository.findAll()
                .stream()
                .map(this::toParentResponse)
                .toList();
    }

    @Override
    public Optional<ParentResponse> findById(Long id){
        return parentRepository.findById(id)
                .map(this::toParentResponse);
    }

    @Override
    public ParentResponse create(ParentUpsertRequest req){
        Parent parent = toParent(req);
        Parent result = parentRepository.save(parent);
        return toParentResponse(result);
    }

    @Override
    public ParentResponse update(Long id, ParentUpsertRequest req){
        Parent parent = toParent(req);
        parent.setId(id);
        Parent result = parentRepository.save(parent);
        return toParentResponse(result);
    }

    @Override
    public void delete(Long id){
        parentRepository.deleteById(id);
    }
}
