package com.javas.yoedu_be.services.impl;

import com.javas.yoedu_be.common.exception.NotFoundException;
import com.javas.yoedu_be.domain.entities.*;
import com.javas.yoedu_be.dto.courseclass.CourseClassCreateRequest;
import com.javas.yoedu_be.dto.courseclass.CourseClassResponse;
import com.javas.yoedu_be.repositories.*;
import com.javas.yoedu_be.services.CourseClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseClassServiceImpl implements CourseClassService {
    private final CourseClassRepository courseClassRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final RoomRepository roomRepository;
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public Page<CourseClassResponse> findAll(Pageable pageable) {
        return courseClassRepository.findAll(pageable)
                .map(courseClass -> modelMapper
                        .map(courseClass, CourseClassResponse.class));
    }

    @Transactional
    public CourseClassResponse create(CourseClassCreateRequest request) {
        CourseClass courseClass = new CourseClass();
        apply(courseClass, request);
        return modelMapper.map(courseClassRepository.save(courseClass), CourseClassResponse.class);
    }
    private void apply(CourseClass courseClass, CourseClassCreateRequest request) {
        Course course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new NotFoundException("Course not found: " + request.courseId()));
        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(() -> new NotFoundException("Room not found: " + request.roomId()));
        ScheduleSlot scheduleSlot = scheduleSlotRepository.findById(request.scheduleSlotId())
                .orElseThrow(() -> new NotFoundException("Schedule slot not found: " + request.scheduleSlotId()));
        Teacher mainTeacher = teacherRepository.findById(request.mainTeacherId())
                .orElseThrow(() -> new NotFoundException("Main teacher not found: " + request.mainTeacherId()));
        Teacher assistantTeacher = request.assistantTeacherId() == null ? null : teacherRepository.findById(request.assistantTeacherId())
                .orElseThrow(() -> new NotFoundException("Assistant teacher not found: " + request.assistantTeacherId()));

        courseClass.setClassCode(request.classCode());
        courseClass.setName(request.name());
        courseClass.setCourse(course);
        courseClass.setRoom(room);
        courseClass.setScheduleSlot(scheduleSlot);
        courseClass.setMainTeacher(mainTeacher);
        courseClass.setAssistantTeacher(assistantTeacher);
        courseClass.setStartDate(request.startDate());
        courseClass.setEndDate(request.endDate());
        courseClass.setMaxStudents(request.maxStudents());
        courseClass.setTuitionFee(request.tuitionFee());
        courseClass.setStatus(request.status());
    }
}
