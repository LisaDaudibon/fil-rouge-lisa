package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Review;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WineDtoIn {
    private String name;
    private String estate;
    private String appellation;
    private String description;
    private Float price;
    private Float alcoholPercentage;
    private String color;
    private String region;
    private Year year;
    private List<String> grapeVarieties;
}
