package com.javas.yoedu_be.services.impl;

import com.javas.yoedu_be.common.exception.NotFoundException;
import com.javas.yoedu_be.domain.entities.Parent;
import com.javas.yoedu_be.domain.entities.Student;
import com.javas.yoedu_be.dto.parent.ParentResponse;
import com.javas.yoedu_be.dto.student.StudentResponse;
import com.javas.yoedu_be.dto.student.StudentUpsertRequest;
import com.javas.yoedu_be.repositories.ParentRepository;
import com.javas.yoedu_be.repositories.StudentRepository;
import com.javas.yoedu_be.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    private StudentResponse map(Student student) {
        Parent parent = student.getParent();
        return new StudentResponse(
                student.getId(),
                student.getStudentCode(),
                student.getFullName(),
                student.getDateOfBirth(),
                student.getGender(),
                student.getGradeLevel(),
                student.getSchoolName(),
                student.getPhone(),
                parent != null ? parent.getId() : null,
                parent != null ? parent.getFullName() : null,
                student.getStatus(),
                student.getLatestScore(),
                student.getNote(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }

    private void apply(Student student, StudentUpsertRequest req) {
        student.setStudentCode(req.getStudentCode());
        student.setFullName(req.getFullName());
        student.setDateOfBirth(req.getDateOfBirth());
        student.setGender(req.getGender());
        student.setGradeLevel(req.getGradeLevel());
        student.setSchoolName(req.getSchoolName());
        student.setPhone(req.getPhone());
        student.setStatus(req.getStatus());
        student.setLatestScore(req.getLatestScore());
        student.setNote(req.getNote());
        if(req.getParentId() == null) {
            student.setParent(null);
        }else{
            Parent parent = parentRepository.findById(req.getParentId())
                    .orElseThrow(() -> new NotFoundException("Parent not found: " + req.getParentId()));
            student.setParent(parent);
        }
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::map).
                toList();
    }

    @Override
    public Optional<StudentResponse> findById(Long id) {
        return studentRepository.findById(id).map(this::map);
    }

    @Override
    public StudentResponse create(StudentUpsertRequest reg) {
        Student student = new Student();
        apply(student, reg);
        Student saved = studentRepository.save(student);
        return map(saved);
    }

    @Override
    public StudentResponse update(Long id, StudentUpsertRequest reg) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found: " + id));
        apply(student, reg);
        Student saved = studentRepository.save(student);
        return map(saved);
    }

    @Override
    public void delete(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new NotFoundException("Student not found: " + id);
        }
        studentRepository.deleteById(id);
    }

    public List<StudentResponse> findByStudentCode(String code) {
        return studentRepository.findByStudentCodeLike("%"+ code + "%")
                .stream()
                .map(this::map)
                .toList() ;

    }
}
