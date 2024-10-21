package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.bo.Professionnel;
import com.example.demo.infrastructure.entity.ProfessionnelEntity;

public class ProfessionelAdapter {

    public static Professionnel mapperVersModele(ProfessionnelEntity entity) {
        if (entity == null) return null;

        return new Professionnel.Builder()
                .raisonSociale(entity.getRaisonSociale())
                .siret(entity.getSiret())
                .chiffreAffaire(entity.getChiffreAffaire())
                .reference(entity.getReference())
                .build();
    }


}
