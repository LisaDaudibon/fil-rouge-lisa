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

    public List<Wine> getAll () { return this.inMemoryWineRepository.getAll(); }

    public Wine getOneById ( int searchedId ) {
        // TODO - gérer les exceptions
        return this.inMemoryWineRepository.getOneById(searchedId);
    }

    public Wine create ( Wine newWine ) {
        // TODO - gérer les exceptions
        return inMemoryWineRepository.save(newWine);
    }
    public void deleteByID ( int searchedId ) {
        // TODO - gérer les exceptions
        Wine deletedWine = getOneById(searchedId);
        this.inMemoryWineRepository.delete(deletedWine);
    }

    public Wine updateById ( int searchedId, Wine wine) {
        //TODO - gérer les exceptions
        Wine updatedWine = this.getOneById(searchedId);
        wine.setId(updatedWine.getId());
        return inMemoryWineRepository.save(wine);
    }
}
