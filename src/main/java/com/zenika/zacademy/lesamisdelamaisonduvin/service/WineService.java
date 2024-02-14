package com.zenika.zacademy.lesamisdelamaisonduvin.service;

import com.zenika.zacademy.lesamisdelamaisonduvin.repository.WineRepository;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.springframework.data.relational.core.sql.Not;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WineService {
    private WineRepository wineRepository;

    public WineService ( WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<Wine> getAll () { return this.wineRepository.getAll(); }

    public Wine getOneById ( int searchedId ) throws NotFoundException {
        // TODO - gérer les exceptions
        return this.wineRepository.getOneById(searchedId);

    }

    public Wine create ( Wine newWine ) throws NotFoundException{
        // TODO - gérer les exceptions
        return wineRepository.save(newWine);
    }
    public void deleteByID ( int searchedId ) throws NotFoundException {
        // TODO - gérer les exceptions
        Wine deletedWine = getOneById(searchedId);
        this.wineRepository.delete(deletedWine);
    }

    public Wine updateById ( int searchedId, Wine wine) throws NotFoundException {
        //TODO - gérer les exceptions
        Wine updatedWine = this.getOneById(searchedId);
        wine.setId(updatedWine.getId());
        return wineRepository.save(wine);
    }
}
