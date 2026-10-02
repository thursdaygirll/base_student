package com.base_student.model;

import java.time.LocalDateTime;

import com.base_student.dto.LogEntryDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logs")
public class LogEntryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "level")
    private String level;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LogEntryDto toDto() {
        return LogEntryDto.builder()
                .id(this.id)
                .message(this.message)
                .level(this.level)
                .createdAt(this.createdAt)
                .build();
    }
}
