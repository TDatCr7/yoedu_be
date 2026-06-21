package com.javas.yoedu_be.repositories;

import com.javas.yoedu_be.domain.entities.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
}
