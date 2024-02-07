package com.zenika.zacademy.lesamisdelamaisonduvin.controller;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {
    private final Logger logger = LoggerFactory.getLogger(WineController.class);
    private WineService wineService;
    //TODO - Ajouter le mappeur WineDtoIn
    public WineController ( WineService wineService) {
        this.wineService = wineService;
    }

    //Port 8082
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Wine> getAll () {
        logger.info("Return a list of all wines");
        return wineService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Wine getOneById (@PathVariable("id") int searchedId) {
        // TODO - Gérer les cas d'erreur (try/catch + exception)
        logger.info("Return the wine associated with the id " + searchedId);
        return wineService.getOneById(searchedId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wine create (@RequestBody Wine newWine) {
        //TODO - Utiliser Hibernate Validator
        Wine wineAdded = wineService.create(newWine);
        logger.info("Wine created : " + wineAdded);
        return wineAdded;
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
    public Wine updateById (@PathVariable("id") int searchedId, @RequestBody Wine wineUpdated) {
        // TODO - Gérer les cas d'erreur (try / catch + exception)
        logger.info("Update a Wine with id " + searchedId);
        return wineService.updateById(searchedId, wineUpdated);
    }
}
