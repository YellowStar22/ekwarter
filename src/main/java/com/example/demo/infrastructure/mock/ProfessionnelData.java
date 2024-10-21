package com.example.demo.infrastructure.mock;

import com.example.demo.domain.bo.Professionnel;
import com.example.demo.infrastructure.ProfessionnelRepository;
import com.example.demo.infrastructure.adapter.ProfessionelAdapter;
import com.example.demo.infrastructure.entity.ProfessionnelEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfessionnelData implements ProfessionnelRepository {

    @Override
    public Professionnel recupereProfessionnel(String reference) {
        ProfessionnelEntity professionnelEntity = null;
        switch (reference) {
            case "EKW00000003":
                professionnelEntity = new ProfessionnelEntity("EKW00000003", "SIRET" ,"RAISON SOCIAL", 10000000);
                break;
            case "EKW00000004":
                professionnelEntity = new ProfessionnelEntity("EKW00000004", "SIRET","RAISON SOCIAL", 20000);
                break;
        }
        return ProfessionelAdapter.mapperVersModele(professionnelEntity);
    }
}
