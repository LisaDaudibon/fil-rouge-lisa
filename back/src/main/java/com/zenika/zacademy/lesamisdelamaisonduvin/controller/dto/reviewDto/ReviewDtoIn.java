package com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.reviewDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDtoIn {
    @NotBlank
    private String author;
    @NonNull
    private int score;
    private String comment;
}
