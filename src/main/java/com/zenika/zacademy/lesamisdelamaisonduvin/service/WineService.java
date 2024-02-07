package com.zenika.zacademy.lesamisdelamaisonduvin.service;

import com.zenika.zacademy.lesamisdelamaisonduvin.repository.InMemoryWineRepository;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {
    private InMemoryWineRepository inMemoryWineRepository;

    public WineService ( InMemoryWineRepository inMemoryWineRepository) {
        this.inMemoryWineRepository = inMemoryWineRepository;
    }

    public List<Wine> getAll () { return inMemoryWineRepository.getAll(); }

    public Wine getOneById ( int searchedId ) {
        return inMemoryWineRepository.getOneById(searchedId);
    }

    public Wine create ( Wine newWine ) {
        return inMemoryWineRepository.save(newWine);
    }
}
