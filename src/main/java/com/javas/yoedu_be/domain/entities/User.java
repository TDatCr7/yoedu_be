package com.javas.yoedu_be.domain.entities;

import com.javas.yoedu_be.domain.AuditableEntity;
import com.javas.yoedu_be.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User extends AuditableEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(name="password_hash",nullable = false)
    private String passwordHash;

    @Column(name="full_name", nullable = false)
    private String fullName;

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Parent parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive=true;
}
