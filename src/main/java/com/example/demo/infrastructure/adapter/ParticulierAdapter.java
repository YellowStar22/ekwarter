package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.bo.Particulier;
import com.example.demo.infrastructure.entity.ParticulierEntity;
public class ParticulierAdapter {

    public static Particulier mapperVersModele(ParticulierEntity entity) {
        if (entity == null) return null;

        return new Particulier.Builder().nom(entity.getNom())
                .prenom(entity.getPrenom())
                .reference(entity.getReference())
                .build();
    }
}
