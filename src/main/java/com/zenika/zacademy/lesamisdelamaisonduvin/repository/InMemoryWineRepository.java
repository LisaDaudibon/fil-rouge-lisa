package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
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
        if (newWine.getId() <= 0 ) {
            newWine.setId(getNextId());
        }
        else {
            wines.remove(getOneById(newWine.getId()));
        }
        wines.add(newWine);
        return newWine;
    }

    public void delete (Wine deletedWine) {
        wines.remove(deletedWine);
    }
}