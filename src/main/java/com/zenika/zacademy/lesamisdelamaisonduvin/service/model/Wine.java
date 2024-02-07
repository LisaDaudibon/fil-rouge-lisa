package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return Objects.equals(name, wine.name) && Objects.equals(estate, wine.estate) && Objects.equals(year, wine.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, estate, year);
    }

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
