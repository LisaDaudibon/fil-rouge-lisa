package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wine {
    private int id;
    private String name;
    private String estate;
    private String appellation;
    private String description;
    private Float price;
    private Float alcoholPercentage;
    private Color color;
    private String region;
    private String grapeVarieties;

    // TODO
    // Model / Controller à créer
    // private Review review;
 }
