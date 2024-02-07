package com.zenika.zacademy.lesamisdelamaisonduvin.repository;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import org.junit.jupiter.api.*;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryWineRepositoryTest {
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

    InMemoryWineRepository inMemoryWineRepository = new InMemoryWineRepository();
     Wine result = inMemoryWineRepository.save(defaultWine);

    @Nested
    class save {

        @Test
        @Order(1)
        @DisplayName("New wine must be saved in in-memory list")
        public void shouldSaveWine() {
            Wine savedResult = inMemoryWineRepository.save(defaultWine);
            assertEquals(savedResult.getId(), 2);
            assertEquals(inMemoryWineRepository.count(), 1);
        }
    }

    @Nested
    class getAll {

        @Test
        @Order(2)
        @DisplayName("New wine must be created")
        public void shouldGetAllTheWines() {
           List <Wine> results = inMemoryWineRepository.getAll();
           assertEquals(results.size(),1);
        }
    }

    @Nested
    class getOneById {

        @Test
        @Order(3)
        @DisplayName("Wine must be found with the id")
        public void shouldGetOneWithId () {
            Wine result = inMemoryWineRepository.getOneById(defaultWine.getId());
            assertEquals(result.getId(), 1);
            assertEquals(inMemoryWineRepository.count(), 1);
        }
    }

    @Nested
    class deleteOneById {

        @Test
        @Order(4)
        @DisplayName("Wine with id must be deleted")
        public void shouldDeleteWithId () {
            inMemoryWineRepository.delete(defaultWine);
            assertEquals(inMemoryWineRepository.count(), 0);
        }
    }
}
