package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import com.zenika.zacademy.lesamisdelamaisonduvin.service.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum GrapeVarieties {
    //RED Wine
    AUXERROIS ("auxerrois"),
    CARBENET_FRANC("Carbenet-Franc"),
    CABERNET_SAUVIGNON("Cabernet Sauvignon"),
    GAMAY_GRENACHE("Gamay Grenache"),
    MERLOT_MOURVEDRE("Merlot Mourvèdre"),
    NEBBIOLO("Nebbiolo"),
    PINOT_NOIR("Pinot Noir"),
    SANGIOVESE_SYRAH("Sangiovese Syrah"),
    TANNAT_TEMPRANILLO("Tannat Tempranillo"),
    ZINFANDEL("Zinfandel"),
    //WHITE wine
    ALIGOTE("Aligoté"),
    CHARDONNAY("Chardonnay"),
    CHENIN("Chenin"),
    GEWURZTRAMINER("Gewürztraminer"),
    MARSANNE("Marsanne"),
    MUSCADET("Muscadet"),
    MUSCAT_BLANC("Muscat Blanc"),
    PETIT_MANSENG("Petit Manseng"),
    RIESLING("Riesling"),
    ROUSSANNE("Roussanne"),
    SAUVIGNON("Sauvignon"),
    SEMILLON("Sémillon"),
    SYLVANER("Sylvaner"),
    VIOGNIER("Viognier"),
    //ROSE wine
    CABERNET_D_ANJOU("Cabernet d’Anjou"),
    CINSAULT("Cinsault"),
    GRENACHE("Grenache"),
    SYRAH("Syrah");

    private String name;

    public static GrapeVarieties findByName(String name) throws BadRequestException {
        return Arrays.stream(values()).filter(grapeVarieties -> grapeVarieties.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(BadRequestException::new);
    }

    public String getName() {
        return name;
    }
}
