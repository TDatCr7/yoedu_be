package com.javas.yoedu_be.domain.entities;

import com.javas.yoedu_be.domain.AuditableEntity;
import com.javas.yoedu_be.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "parents")
public class Parent extends AuditableEntity {

    @Column(name = "full_name")
    private String fullName;
    private String phone;
    private String email;
    private String address;

}
