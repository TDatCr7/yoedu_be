package com.javas.yoedu_be.repositories;

import com.javas.yoedu_be.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT o FROM Student o WHERE o.studentCode LIKE :code")
    public List<Student> findByStudentCodeLike(@Param("code") String code);

}
