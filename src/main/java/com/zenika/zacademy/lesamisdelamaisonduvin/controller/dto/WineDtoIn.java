package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WineDtoIn {
    @NotBlank
    private String name;
    @NotBlank
    private String estate;
    private String appellation;
    private String description;
    @DecimalMin("0")
    @DecimalMax("9999")
    private Float price;
    @DecimalMin("0")
    @DecimalMax("100")
    private Float alcoholPercentage;
    @NonNull
    private String color;
    @NotBlank
    private String region;
    @NonNull
    private Year year;
    @NotEmpty
    private List<String> grapeVarieties;
}
