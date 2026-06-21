package com.javas.yoedu_be.dto.parent;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParentUpsertRequest {

    private String fullName;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
