package com.zenika.zacademy.lesamisdelamaisonduvin.controller;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {
    private final Logger logger = LoggerFactory.getLogger(WineController.class);
    private WineService wineService;
    public WineController ( WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public List<Wine> getAll () {
        logger.info("Return a list of all wines");
        return this.wineService.getAll();
    }
}
