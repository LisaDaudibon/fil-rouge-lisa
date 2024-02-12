package com.zenika.zacademy.lesamisdelamaisonduvin.service;

import com.zenika.zacademy.lesamisdelamaisonduvin.repository.InMemoryWineRepository;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WineServiceTest {
    private final Wine defaultWine = Wine.builder()
            .name("Parcelle de Jean Rouge")
            .estate("Jeannine Boutin")
            .description("""
                    Maison de vins créé en 2007 par Stéphane Vedeau (La ferme du Mont / Clos Bellane) et sa mère Jeanne Boutin.
                    Travaillant depuis longtemps sur les vignes de la Vallée du Rhône Sud, Stéphane a fait le pari de vinifier des appellations du Rhône septentrionnal.""")
            .region("Rhône")
            .color(WineColors.RED)
            .year(Year.of(2020))
            .price(26.5F)
            .grapeVarieties(List.of(GrapeVarieties.SYRAH))
            .build();

    private final InMemoryWineRepository inMemoryWineRepository = new InMemoryWineRepository();
    private final WineService wineService = new WineService(inMemoryWineRepository);

    private List<Wine> resultingList = new ArrayList<>();

//    @Nested
//    @Order(1)
//    class create {

//    }

//    @Nested
//    @Order(2)
//    class getAll {
//
//        @Test
////        @Order(2)
//        public void shouldGetAllWine () {
////            Wine addedWine = wineService.create(defaultWine);
//            resultingList = wineService.getAll();
//
//            assertEquals(resultingList.size(), 1);
//        }
//    }

//    @Nested
//    @Order(2)
//    class getOneById {

        @Test
        @Order(2)
        public void shouldGetOneById () {
//            Wine addedWine = wineService.create(defaultWine);
            Wine wineFound = wineService.getOneById(1);

            assertEquals(wineFound.getId(), 1);
            assertEquals(wineFound.getName(), "Parcelle de Jean Rouge");
        }
//    }
    @Test
    @Order(1)
    public void shouldCreateNewWine() {
        Wine result = wineService.create(defaultWine);

        assertEquals(result.getId(), 1);
        assertEquals(wineService.getAll().size(), 1);
    }
}