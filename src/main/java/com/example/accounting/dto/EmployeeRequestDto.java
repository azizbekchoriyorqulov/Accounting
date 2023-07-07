package com.example.accounting.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRequestDto {
    @NotBlank(message = "Firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "Lastname cannot be blank")
    private String lastName;
    @NotBlank(message = "Pinfl cannot be blank")
    private String pinfl;
    @NotBlank(message = "Organization id cannot be blank")
    private UUID organizationId;
}
