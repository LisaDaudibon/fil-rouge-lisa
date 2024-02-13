package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;

public class WineMapper {
    public WineDtoOut toDto(Wine from) {
        return WineDtoOut.builder()
                .id(from.getId())
                .name(from.getName())
                .estate(from.getEstate())
                .region(from.getRegion())
                .description(from.getDescription())
                .price(from.getPrice())
                .year(from.getYear())
                .color(from.getColor())
                .grapeVarieties(from.getGrapeVarieties().stream().map(GrapeVarieties::getName).toList())
                .alcoholPercentage(from.getAlcoholPercentage())
                .appellation(from.getAppellation())
//                .reviews(from.getReviews().stream().map(reviewMapper::toDto).toList())
                .build();
    }

//    public Wine wineDtoOutToWine ( WineDtoOut from ) {
//        return new Wine ( from.getName(), from.getAppellation(), from.getEstate(), from.getDescription(),
//                from.getPrice(), from.getAlcoholPercentage(), from.getColor(), from.getRegion(), from.getYear(),
//                from.getGrapeVarieties() );
//    }
}
