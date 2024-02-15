package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Review;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
//@Profile("memory")
public class InMemoryWineRepository implements WineRepository{

    private final Set<Wine> wines = new HashSet<>();

    public List<Wine> getAll() {
        return wines.stream().toList();
    }
    public long count() {
        return wines.size();
    }

    public int getNextId() {
        final int nextId;
        if (wines.isEmpty()) {
            nextId = 1;
        } else {
            nextId = Collections.max(wines.stream() .map(Wine::getId).toList()) + 1;
        }
        return nextId;
    }

    public int getNextReviewId() {
        try {
            return Collections.max(wines.stream().flatMap(wine -> wine.getReviews().stream().map(Review::getId)).toList()) + 1;
        } catch (NoSuchElementException exception) {
            return 1;
        }
    }

    public Wine getOneById ( int searchedId ) throws NotFoundException {
        for (Wine wine : wines) {
            if (wine.getId() == searchedId ) {
                return wine;
            }
        }
        throw new NotFoundException();
    }

    public Wine save ( Wine newWine ) throws NotFoundException {
        if (newWine.getId() <= 0 ) {
            newWine.setId(getNextId());
        } else {
            wines.remove(getOneById(newWine.getId()));
        }

        wines.add(newWine);
        return newWine;
    }

    public void delete (Wine deletedWine) {
        wines.remove(deletedWine);
    }
}
