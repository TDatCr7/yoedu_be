package com.javas.yoedu_be.controllers;

import com.javas.yoedu_be.common.ApiResponse;
import com.javas.yoedu_be.dto.course.CourseResponse;
import com.javas.yoedu_be.dto.course.CourseUpsertRequest;
import com.javas.yoedu_be.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ApiResponse<List<CourseResponse>> findAll()
    {

        return ApiResponse.success(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable Long id)
    {
        Optional<CourseResponse> result = courseService.findById(id);

        if(result.isPresent())
        {
            return ApiResponse.success(result.get());
        }
        else
        {
            return ApiResponse.error("Not Found");
        }
    }

    @PostMapping
    public ApiResponse<CourseResponse> cretate(@Validated @RequestBody CourseUpsertRequest reg){
        return ApiResponse.success(courseService.create(reg));
    }

    @PutMapping("/{id}")
    public ApiResponse<CourseResponse> update(@PathVariable Long id, @RequestBody CourseUpsertRequest reg){
        return ApiResponse.success(courseService.update(id, reg));
    }

}
