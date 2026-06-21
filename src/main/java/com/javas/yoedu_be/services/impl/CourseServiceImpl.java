package com.javas.yoedu_be.services.impl;

import com.javas.yoedu_be.domain.entities.Course;
import com.javas.yoedu_be.dto.course.CourseResponse;
import com.javas.yoedu_be.dto.course.CourseUpsertRequest;
import com.javas.yoedu_be.repositories.CourseRepository;
import com.javas.yoedu_be.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    private Course toCourse(CourseUpsertRequest req) {
        return modelMapper.map(req, Course.class);
    }

    private CourseResponse toCourseResponse(Course course) {
        return modelMapper.map(course, CourseResponse.class);
    }


    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(this::toCourseResponse)
                .toList();
    }

    @Override
    public Optional<CourseResponse> findById(Long id){
        return courseRepository.findById(id)
                .map(this::toCourseResponse);
    }

    @Override
    public CourseResponse create(CourseUpsertRequest req) {
        Course course = toCourse(req);
        Course result = courseRepository.save(course);
        return toCourseResponse(result);
    }

    @Override
    public CourseResponse update(Long id, CourseUpsertRequest req) {
        Course course = toCourse(req);
        course.setId(id);
        Course result = courseRepository.save(course);
        return toCourseResponse(result);
    }

    @Override
    public void delete(Long id){
        courseRepository.deleteById(id);
    }
}
