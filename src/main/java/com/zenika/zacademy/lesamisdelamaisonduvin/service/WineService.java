package com.zenika.zacademy.lesamisdelamaisonduvin.service;

import com.zenika.zacademy.lesamisdelamaisonduvin.repository.WineRepository;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.DuplicateRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Review;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
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
        return this.wineRepository.getOneById(searchedId);
    }

    public Wine create ( Wine newWine ) throws NotFoundException{
        return wineRepository.save(newWine);
    }
    public void deleteByID ( int searchedId ) throws NotFoundException {
        Wine deletedWine = getOneById(searchedId);
        this.wineRepository.delete(deletedWine);
    }

    public Wine updateById ( int searchedId, Wine wine) throws NotFoundException {
        Wine updatedWine = this.getOneById(searchedId);
        wine.setId(updatedWine.getId());
        return wineRepository.save(wine);
    }

    public Review saveReviewToWine ( int searchedWineId, Review newReview ) throws NotFoundException, DuplicateRequestException {
        Wine wineFound = this.getOneById(searchedWineId);

        if (wineFound.getReviews().equals(newReview)) {
            throw new DuplicateRequestException();
        } else {
            Review savedReview = Review.builder()
                    .id(this.wineRepository.getNextReviewId())
                    .score(newReview.getScore())
                    .author(newReview.getAuthor())
                    .comment(newReview.getComment())
                    .createdAt(Instant.now())
                    .build();

            wineFound.getReviews().add(savedReview);
            this.wineRepository.save(wineFound);

            return savedReview;
        }
    }
}
