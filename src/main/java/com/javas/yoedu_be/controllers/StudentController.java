package com.javas.yoedu_be.controllers;

import com.javas.yoedu_be.common.ApiResponse;
import com.javas.yoedu_be.dto.student.StudentResponse;
import com.javas.yoedu_be.dto.student.StudentUpsertRequest;
import com.javas.yoedu_be.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ApiResponse<List<StudentResponse>> findAll(){

        return ApiResponse.success(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable Long id){
        Optional<StudentResponse> result = studentService.findById(id);

        if(result.isPresent())
            return ApiResponse.success(result.get());
        else
            return ApiResponse.error("Student["+id+"] not found");
    }

    @PostMapping
    public ApiResponse<StudentResponse> create(@Validated @RequestBody StudentUpsertRequest req){
        return ApiResponse.success(studentService.create(req));
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentResponse> update(@PathVariable Long id, @RequestBody StudentUpsertRequest reg){
        return ApiResponse.success(studentService.update(id, reg));
    }



}
