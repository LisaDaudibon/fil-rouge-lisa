package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Review {
    private int id;
    private String author;
    private int score;
    private String comment;
    private LocalDate createdAt;
}
