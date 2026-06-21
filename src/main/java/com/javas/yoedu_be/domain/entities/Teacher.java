package com.javas.yoedu_be.domain.entities;

import com.javas.yoedu_be.domain.AuditableEntity;
import com.javas.yoedu_be.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher extends AuditableEntity {

    @Column(name = "teacher_code")
    private String teacherCode;

    @Column(name = "full_name")
    private String fullName;

    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "teacher_role")
    private Role teacherRole;

    @Column(name = "cccd_image_url")
    private String cccdImageUrl;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
