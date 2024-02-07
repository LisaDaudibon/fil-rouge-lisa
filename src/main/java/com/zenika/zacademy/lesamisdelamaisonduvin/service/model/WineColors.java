package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WineColors {
    RED("rouge"),
    WHITE("blanc"),
    ROSE("rosé");

    private final String wineColor;
}
