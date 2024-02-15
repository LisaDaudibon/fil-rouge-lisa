package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.reviewDto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDtoOut {
    private int id;
    private String author;
    private int score;
    private String comment;
    private Instant createdAt;
}
