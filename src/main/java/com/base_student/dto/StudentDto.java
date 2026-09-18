package com.base_student.dto;

import com.base_student.model.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String name;
    private String lastName;
    private String phone;
    private String eMail;

    public StudentModel toModel() {
        return StudentModel.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .phone(this.phone)
                .eMail(this.eMail)
                .build();
    }

}
