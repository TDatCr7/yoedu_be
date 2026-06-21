package com.javas.yoedu_be.services;

import com.javas.yoedu_be.domain.entities.Teacher;
import com.javas.yoedu_be.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    public final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
