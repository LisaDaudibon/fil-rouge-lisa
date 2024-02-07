package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wine {
    private int id;
    private String name;
    private String estate;
    private String appellation;
    private String description;
    private Float price;
    private Float alcoholPercentage;
    private Colors color;
    private String region;
    private Year year;
    private List<GrapeVarieties> grapeVarieties;

    // TODO
    // Service / Controller à créer
     private final List<Review> review = new ArrayList<>();

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", estate='" + estate + '\'' +
                ", appellation='" + appellation + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", alcoholPercentage=" + alcoholPercentage +
                ", color=" + color +
                ", region='" + region + '\'' +
                ", year=" + year +
                ", grapeVarieties=" + grapeVarieties +
                ", review=" + review +
                '}';
    }
}
