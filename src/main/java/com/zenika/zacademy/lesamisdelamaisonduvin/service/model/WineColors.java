package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum WineColors {
    RED("rouge"),
    WHITE("blanc"),
    ROSE("rosé");

    private final String wineColor;

    public static WineColors findByColor (String wineColor) throws BadRequestException {
        return Arrays.stream(values()).filter(wineColors -> wineColors.wineColor.contentEquals(wineColor))
                .findFirst()
                .orElseThrow(BadRequestException::new);
    }

    public String getColor() { return wineColor; };
}
