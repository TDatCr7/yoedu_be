package com.javas.yoedu_be.repositories;

import com.javas.yoedu_be.domain.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
