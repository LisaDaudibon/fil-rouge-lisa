package com.zenika.zacademy.lesamisdelamaisonduvin.controller;

import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.reviewDto.ReviewDtoOut;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.reviewDto.ReviewMapper;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.wineDto.WineDtoIn;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.wineDto.WineDtoOut;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.wineDto.WineMapper;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.DuplicateRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Review;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wines")
public class WineController {
    private final Logger logger = LoggerFactory.getLogger(WineController.class);

    private WineService wineService;
    private WineMapper wineMapper;
    private ReviewMapper reviewMapper;

    public WineController ( WineService wineService, WineMapper wineMapper, ReviewMapper reviewMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
        this.reviewMapper = reviewMapper;
    }

    //Port 8082
    @GetMapping
    @Operation(summary = "Get a list of all the wine")
    @ResponseStatus(HttpStatus.OK)
    public List<WineDtoOut> getAll () {
        logger.info("Return a list of all wines");
        List<Wine> wines = wineService.getAll();
        List <WineDtoOut> winesDtoOut = new ArrayList<>();
        for (Wine wine : wines)
            winesDtoOut.add(wineMapper.toDto(wine));
        return winesDtoOut;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a wine using it's id")
    @ResponseStatus(HttpStatus.OK)
    public WineDtoOut getOneById (@PathVariable("id") int searchedId) throws NotFoundException {
        logger.info("Return the wine associated with the id " + searchedId);
        return wineMapper.toDto(wineService.getOneById(searchedId));
    }

    @PostMapping
    @Operation(summary = "Create a new wine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The wine created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = WineDtoOut.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid wine object supplied", content = @Content),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public WineDtoOut create (@RequestBody @Valid WineDtoIn newWine) throws BadRequestException, NotFoundException {
        try {
            Wine wineAdded = this.wineService.create(wineMapper.toModel(newWine));

            logger.info("Wine created : " + wineAdded);
            return this.wineMapper.toDto(wineAdded);
        } catch (BadRequestException e) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a wine using id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable("id") int searchedId) throws NotFoundException{
        logger.info("Deleted wine with id " + searchedId);
        wineService.deleteByID(searchedId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one wine with id")
    @ResponseStatus(HttpStatus.CREATED)
    public WineDtoOut updateById (@PathVariable("id") int searchedId, @RequestBody @Valid WineDtoIn wineUpdated) throws BadRequestException, NotFoundException {
        logger.info("Update a Wine with id " + searchedId);
        return wineMapper.toDto(wineService.updateById(searchedId, wineMapper.toModel(wineUpdated)));
    }

    @PostMapping("/{id}/reviews")
    @Operation(summary = "Create a new review for a wine")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDtoOut saveReview (@PathVariable("id") int searchedId, @RequestBody @Valid Review newReview ) throws DuplicateRequestException, NotFoundException {
        logger.info("Create a new review " + newReview);
        return reviewMapper.toDto(wineService.saveReviewToWine(searchedId, newReview));
    }

    @DeleteMapping("/{wineId}/reviews/{reviewId}")
    @Operation(summary = "Delete a review from a wine")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview ( @PathVariable("wineId") int searchedWineId, @PathVariable("reviewId") int deletedReviewId) throws NotFoundException {
        logger.info("Delete review with id " + deletedReviewId + " from wine with id " + searchedWineId);
        this.wineService.deleteReviewFromWine(searchedWineId, deletedReviewId);
    }
}
