package com.zenika.zacademy.lesamisdelamaisonduvin.controller;

import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineDtoIn;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineDtoOut;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineMapper;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.NotFoundException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    public WineController ( WineService wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
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
        // TODO - Gérer les cas d'erreur (try/catch + exception)
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
    public WineDtoOut create (@RequestBody WineDtoIn newWine) throws BadRequestException, NotFoundException {
        //TODO - Finish handling exception
        try {
            Wine wineAdded = this.wineService.create(wineMapper.toModel(newWine));
            logger.info("Wine created : " + wineAdded);
            return this.wineMapper.toDto(wineAdded);
        } catch (NotFoundException e) {
            throw new NotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a wine using id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable("id") int searchedId) throws NotFoundException{
        // TODO - Gérer les cas d'erreurs (try/catch + exception)
        logger.info("Deleted wine with id " + searchedId);
        wineService.deleteByID(searchedId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one wine with id")
    @ResponseStatus(HttpStatus.CREATED)
    public WineDtoOut updateById (@PathVariable("id") int searchedId, @RequestBody WineDtoIn wineUpdated) throws BadRequestException, NotFoundException {
        // TODO - Gérer les cas d'erreur (try / catch + exception)
        logger.info("Update a Wine with id " + searchedId);
        return wineMapper.toDto(wineService.updateById(searchedId, wineMapper.toModel(wineUpdated)));
    }
}
