package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WineMapper {
    public WineDtoOut toDto(Wine from) {
        return WineDtoOut.builder()
                .id(from.getId()) //Wine send his id to the Dto but the Dto doesn't send one back
                .name(from.getName())
                .estate(from.getEstate())
                .region(from.getRegion())
                .description(from.getDescription())
                .price(from.getPrice())
                .year(from.getYear())
                .color(from.getColor().getColor())
                .grapeVarieties(from.getGrapeVarieties().stream().map(GrapeVarieties::getName).toList())
                .alcoholPercentage(from.getAlcoholPercentage())
                .appellation(from.getAppellation())
//                .reviews(from.getReviews().stream().map(reviewMapper::toDto).toList())
                .build();
    }

        public Wine toModel(WineDtoIn from) throws BadRequestException {
        List<GrapeVarieties> grapeVarieties = new ArrayList<>();
        for (String grapeVarietiesName : from.getGrapeVarieties()) {
            grapeVarieties.add(GrapeVarieties.findByName(grapeVarietiesName));
        }
        return Wine.builder()
                .name(from.getName())
                .estate(from.getEstate())
                .region(from.getRegion())
                .description(from.getDescription())
                .price(from.getPrice())
                .year(from.getYear())
                .color(WineColors.findByColor(from.getColor()))
                .grapeVarieties(grapeVarieties)
                .alcoholPercentage(from.getAlcoholPercentage())
                .appellation(from.getAppellation())
                .build();
    }
}
