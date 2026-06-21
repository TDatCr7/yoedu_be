package com.javas.yoedu_be.repositories;

import com.javas.yoedu_be.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
