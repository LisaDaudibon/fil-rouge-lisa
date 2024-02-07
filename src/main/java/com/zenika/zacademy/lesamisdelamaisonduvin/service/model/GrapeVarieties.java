package com.zenika.zacademy.lesamisdelamaisonduvin.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
}
