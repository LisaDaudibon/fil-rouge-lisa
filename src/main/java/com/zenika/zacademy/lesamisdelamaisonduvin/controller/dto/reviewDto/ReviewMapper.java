package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.reviewDto;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toModel ( ReviewDtoIn from ) {
        return Review.builder()
                .author(from.getAuthor())
                .score(from.getScore())
                .comment(from.getComment())
                .build();
    }

    public ReviewDtoOut toDto ( Review from) {
        return ReviewDtoOut.builder()
                .id(from.getId())
                .author(from.getAuthor())
                .score(from.getScore())
                .comment(from.getComment())
                .createdAt(from.getCreatedAt())
                .build();
    }
}
