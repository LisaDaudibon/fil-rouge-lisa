package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private List<GrapeVarieties> grapeVarieties;

    // TODO
    // Service / Controller à créer
     private List<Review> review;
 }
