package com.example.divistant.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "nik is required")
    @Size(min = 16, max = 16, message = "nik is must be 16 character")
    @JsonProperty("nik")
    private String Nik;

    @NotBlank(message = "name is required")
    @JsonProperty("name")
    private String Name;

    @NotNull(message = "income is required")
    @JsonProperty("income")
    private Integer Income;

    public CustomerRequest(String nik, String name, Integer income) {
        Nik = nik;
        Name = name;
        Income = income;
    }
}
