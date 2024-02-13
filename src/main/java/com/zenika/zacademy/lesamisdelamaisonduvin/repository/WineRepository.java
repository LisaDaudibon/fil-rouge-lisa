package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;

import java.util.List;

public interface WineRepository {
    List<Wine> getAll ();
    Wine save (Wine newWine);
    Wine getOneById(int searchedId);
    void delete(Wine deletedWine);
    long count();
}
