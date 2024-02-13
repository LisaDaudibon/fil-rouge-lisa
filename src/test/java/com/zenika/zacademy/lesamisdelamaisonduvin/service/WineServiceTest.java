package com.zenika.zacademy.lesamisdelamaisonduvin.service;

import com.zenika.zacademy.lesamisdelamaisonduvin.repository.InMemoryWineRepository;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import org.junit.jupiter.api.*;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    List<Wine> allWine = wineService.getAll();

    @BeforeEach
    void shouldSetupTest() {
//        allWine.clear();
        wineService.create(defaultWine);
    }


    @Nested
    class create {

        @Test
        @Order(1)
        public void shouldCreateNewWine() {
            Wine addedWine = Wine.builder()
                    .name("Parcelle de Jean")
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
            long wineCount = inMemoryWineRepository.count();
            Wine result = wineService.create(addedWine);

            assertEquals(result.getId(), 2);
            assertEquals(inMemoryWineRepository.count(), wineCount + 1);
        }
    }

    @Nested
    class getAll {

        @Test
        @Order(2)
        public void shouldGetAllWine () {
            List <Wine> resultingList = wineService.getAll();

            assertEquals(inMemoryWineRepository.count(), 1);
        }
    }

    @Nested
    class getOneById {

        @Test
        @Order(3)
        public void shouldGetOneById () {
            Wine wineFound = wineService.getOneById(1);

            assertEquals(wineFound.getId(), 1);
            assertEquals(wineFound.getName(), "Parcelle de Jean Rouge");
        }
    }
}
