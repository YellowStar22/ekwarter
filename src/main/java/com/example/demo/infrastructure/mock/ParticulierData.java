package com.example.demo.infrastructure.mock;

import com.example.demo.domain.bo.Civilite;
import com.example.demo.domain.bo.Particulier;
import com.example.demo.infrastructure.ParticulierRepository;
import com.example.demo.infrastructure.adapter.ParticulierAdapter;
import com.example.demo.infrastructure.entity.ParticulierEntity;
import org.springframework.stereotype.Component;

@Component
public class ParticulierData implements ParticulierRepository {

    @Override
    public Particulier recupereParticulier(String reference) {
        ParticulierEntity particulierEntity = null;
        switch (reference){
            case "EKW00000001":
                particulierEntity =  new ParticulierEntity("EKW00000001", Civilite.MONSIEUR,"Nom","Prenom");
                break;
            case "EKW00000002":
                particulierEntity =  new ParticulierEntity("EKW00000002", Civilite.MADAME,"Nom","Prenom");
                break;

        }
        return ParticulierAdapter.mapperVersModele(particulierEntity);
    }
}
