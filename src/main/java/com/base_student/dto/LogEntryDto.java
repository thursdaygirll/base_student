package com.base_student.dto;

import java.time.LocalDateTime;

import com.base_student.model.LogEntryModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogEntryDto {

    private Long id;

    @NotBlank(message = "Message is required")
    private String message;

    private String level;

    private LocalDateTime createdAt;

    public LogEntryModel toModel() {
        return LogEntryModel.builder()
                .id(this.id)
                .message(this.message)
                .level(this.level)
                .createdAt(this.createdAt != null ? this.createdAt : LocalDateTime.now())
                .build();
    }
}
