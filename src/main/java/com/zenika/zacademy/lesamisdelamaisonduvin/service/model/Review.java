package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private int id;
    private String author;
    private int score;
    private String comment;
    private LocalDate createdAt;
}
