package com.base_student.dto;

import com.base_student.model.SupplierModel;

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
public class SupplierDto {

    private Long id;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Contact email must be valid")
    private String contactEmail;

    public SupplierModel toModel() {
        return SupplierModel.builder()
                .id(this.id)
                .companyName(this.companyName)
                .contactEmail(this.contactEmail)
                .build();
    }
}
