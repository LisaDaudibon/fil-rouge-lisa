package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryWineRepository {

    private static final Set<Wine> wines = new HashSet<>();

    public List<Wine> getAll() {
        return wines.stream().toList();
    }
    private int getNextId() {
        final int nextId;
        if (wines.isEmpty()) {
            nextId = 1;
        } else {
            nextId = Collections.max(wines.stream() .map(Wine::getId).toList()) + 1;
        }
        return nextId;
    }

    public Wine getOneById ( int searchedId ) {
        for (Wine wine : wines) {
            if (wine.getId() == searchedId ) {
                return wine;
            }
        }
        return null;
    }

    public Wine save ( Wine newWine ) {
        newWine.setId(getNextId());
        wines.add(newWine);
        return newWine;
    }
}
