package com.javas.yoedu_be.controllers;

import com.javas.yoedu_be.dto.parent.ParentResponse;
import com.javas.yoedu_be.services.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public List<ParentResponse> getParents() {

        return parentService.findAll();
    }
}
