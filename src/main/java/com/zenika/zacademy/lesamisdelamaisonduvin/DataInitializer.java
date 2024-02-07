package com.zenika.zacademy.lesamisdelamaisonduvin;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.WineService;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.WineColors;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.GrapeVarieties;
import com.zenika.zacademy.lesamisdelamaisonduvin.service.model.Wine;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    private final WineService wineService;

    public DataInitializer(WineService wineService) {
        this.wineService = wineService;
    }

    @PostConstruct
    public void init() throws Exception {
        // Création des vins
        Wine gigondas = Wine.builder()
                .name("Le vieux clocher")
                .estate("Maison Arnoux & Fils")
                .appellation("Gigondas")
                .region("Vallée du Rhône")
                .description("L'AOC Gigondas produit des vins reconnus comme puissants, charpentés, tanniques, et à forte teneur en alcool, qui rappellent que Châteauneuf-du-Pape n'est pas loin. Leur nez est bouqueté d'épices et d'un parfum d'olives noires, et leur robe sombre. Ce sont de très bons vins de garde, qu'une dizaine d'années subliment.")
                .year(Year.of(2019))
                .color(WineColors.RED)
                .price(20.9f)
                .alcoholPercentage(15f)
                .grapeVarieties(Arrays.asList(GrapeVarieties.GRENACHE, GrapeVarieties.SYRAH))
                .build();

        Wine chateauneuDuPape = Wine.builder()
                .name("Chapouins vieilles vignes")
                .estate("Famille Perrin")
                .appellation("Châteauneuf-du-Pape")
                .region("Vallée du Rhône")
                .description("Le Châteauneuf-du-pape rouge peut être issu de cépages multiples (13 en tout). C'est le Grenache qui domine en délivrant un mélange de finesse et de puissance qui est le signe des grands vins.")
                .year(Year.of(2015))
                .color(WineColors.RED)
                .price(99f)
                .alcoholPercentage(14.5f)
                .grapeVarieties(Arrays.asList(GrapeVarieties.GRENACHE, GrapeVarieties.SYRAH))
                .build();

        Wine moutonCadet = Wine.builder()
                .name("Réserve Mouton Cadet")
                .estate("Baron Philippe de Rothschild")
                .appellation("Pauillac")
                .region("Bordeaux")
                .description("Ce magnifique Pauillac Réserve Mouton Cadet de la très célèbre maison Philippe de Rothschild est une explosion d'arômes de fruits noirs et de poivre. Son nez est très ouvert et expressif, avec un très grand boisé. Son attaque en bouche est charnue et veloutée, avec une finale ronde et souple. Ce vin de garde, produit en quantité limitée et typique de son appellation, accompagne parfaitement les viandes rouges rôties, le gibier et un magnifique plateau de fromages.")
                .year(Year.of(2019))
                .color(WineColors.RED)
                .price(29.9f)
                .alcoholPercentage(13.5f)
                .grapeVarieties(Arrays.asList(GrapeVarieties.MERLOT_MOURVEDRE, GrapeVarieties.CARBENET_FRANC, GrapeVarieties.CABERNET_SAUVIGNON))
                .build();

        Wine graves = Wine.builder()
                .name("Chateau Peyron Bouche")
                .appellation("Graves")
                .region("Bordeaux")
                .description("Pour être moins connu que le Ch. de Landiras, Peyron Bouché n'en demeure pas moins un fort joli cru qui bénéficie des mêmes soins. Témoin ce superbe 2015 à dominante de merlot. À l'intensité de sa robe aux reflets violines répond celle d'un bouquet frais et franc, qui affiche sa jeunesse par ses arômes complexes de fruits rouges épicés, soutenus par un subtil boisé aux nuances de cèdre. Au palais s'établit un bel équilibre des saveurs, entre arômes du raisin et tanins réglissés. Un vin très bien élevé et prometteur.")
                .year(Year.of(2019))
                .color(WineColors.RED)
                .price(12.15f)
                .alcoholPercentage(12.5f)
                .grapeVarieties(List.of(GrapeVarieties.ALIGOTE, GrapeVarieties.CABERNET_SAUVIGNON))
                .build();

        Wine saintJoseph = Wine.builder()
                .name("Les granilites blanc")
                .estate("M. Chapoutier")
                .appellation("Saint-Joseph")
                .region("Rhône")
                .description("Sa robe jaune intense aux reflets verts laisse échapper au nez des arômes frais et délicats de fleurs blanches ainsi que des notes gourmandes de pêche et de poire soulignées d’un joli boisé fondu. En bouche, l’attaque est fraîche et équilibrée, le volume gourmand, la tension minérale est bien présente et la finale se montre longue et persistante. Un très beau Saint-Joseph blanc à déguster frais à l’apéritif, ou en entrée sur un plateau de fruits de mer !")
                .year(Year.of(2020))
                .color(WineColors.WHITE)
                .price(33.7f)
                .alcoholPercentage(14.5f)
                .grapeVarieties(List.of(GrapeVarieties.MARSANNE))
                .build();

        Wine codeDeProvence = Wine.builder()
                .name("M de Minuty")
                .appellation("Côtes de Provence")
                .region("Provence -Alpes-Côte d'Azur")
                .description("Dans la lignée des vins blancs du domaine : sa robe dorée dévoile une belle minéralité. Ses notes acidulées de citron vert et de pamplemousse laissent une agréable fraîcheur et une bonne longueur en bouche. Une cuvée simple et pourtant si séductrice !")
                .year(Year.of(2022))
                .color(WineColors.WHITE)
                .price(16.5f)
                .alcoholPercentage(13f)
                .grapeVarieties(List.of(GrapeVarieties.SEMILLON))
                .build();

        Wine rocheMazet = Wine.builder()
                .name("Jalade rose")
                .estate("Domaine de la Clapiere")
                .appellation("Pays d'Oc")
                .region("Languedoc Roussillon")
                .description("Le domaine de la Clapière est situé dans les hauteurs, au milieu de la garrigue et des champs d'oliviers face à l'Etang de Thau, connu pour son activité ostréicole. C'est dans ce cadre idyllique de les vignes bénéficient d'un climat méditerranéen aux influences marines. On retrouve cette salinité dans la cuvée Jalade, qui fait saliver et donne envie d'y retourner.")
                .year(Year.of(2022))
                .color(WineColors.ROSE)
                .price(6.2f)
                .alcoholPercentage(12f)
                .grapeVarieties(List.of(GrapeVarieties.GRENACHE, GrapeVarieties.SYRAH))
                .build();

        this.wineService.create(gigondas);
        this.wineService.create(chateauneuDuPape);
        this.wineService.create(moutonCadet);
        this.wineService.create(graves);
        this.wineService.create(saintJoseph);
        this.wineService.create(codeDeProvence);
        this.wineService.create(rocheMazet);
    }
}

