package com.zenika.zacademy.lesamisdelamaisonduvin.controller;

import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineDtoIn;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineDtoOut;
import com.zenika.zacademy.lesamisdelamaisonduvin.controller.dto.WineMapper;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
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

    //TODO - Ajouter le mappeur WineDtoIn
    public WineController ( WineService wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    //Port 8082
    @GetMapping
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
    @ResponseStatus(HttpStatus.OK)
    public WineDtoOut getOneById (@PathVariable("id") int searchedId) {
        // TODO - Gérer les cas d'erreur (try/catch + exception)
        logger.info("Return the wine associated with the id " + searchedId);
        return wineMapper.toDto(wineService.getOneById(searchedId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WineDtoOut create (@RequestBody WineDtoIn newWine) throws BadRequestException {
        //TODO - Utiliser Hibernate Validator
        Wine wineAdded = this.wineService.create(wineMapper.toModel(newWine));
        logger.info("Wine created : " + wineAdded);
        return this.wineMapper.toDto(wineAdded);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable("id") int searchedId){
        // TODO - Gérer les cas d'erreurs (try/catch + exception)
        logger.info("Deleted wine with id " + searchedId);
        wineService.deleteByID(searchedId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public WineDtoOut updateById (@PathVariable("id") int searchedId, @RequestBody WineDtoIn wineUpdated) throws BadRequestException {
        // TODO - Gérer les cas d'erreur (try / catch + exception)
        logger.info("Update a Wine with id " + searchedId);
        return wineMapper.toDto(wineService.updateById(searchedId, wineMapper.toModel(wineUpdated)));
    }
}
