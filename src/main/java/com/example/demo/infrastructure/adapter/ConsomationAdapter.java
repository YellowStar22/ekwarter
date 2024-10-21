package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.bo.Consommation;
import com.example.demo.infrastructure.entity.ConsommationEntity;

public class ConsomationAdapter {

    // Convert ConsomationEntity to Consomation
    public static Consommation mapperVersModele(ConsommationEntity entity) {
        if (entity == null) return null;

        Consommation consomation = new Consommation();
        consomation.setElectricity(entity.getElectricity());
        consomation.setGaz(entity.getGaz());

        return consomation;
    }

}
