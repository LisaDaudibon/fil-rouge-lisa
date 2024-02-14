package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;

import java.util.List;

public interface WineRepository {
    List<Wine> getAll ();
    int getNextId();
    int getNextReviewId();
    Wine save (Wine newWine) throws NotFoundException;
    Wine getOneById(int searchedId) throws NotFoundException;
    void delete(Wine deletedWine) throws NotFoundException;
    long count();
}
