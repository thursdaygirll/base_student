package com.base_student.dto;

import com.base_student.model.ClientModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    private String phone;

    public ClientModel toModel() {
        return ClientModel.builder()
                .id(this.id)
                .fullName(this.fullName)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
