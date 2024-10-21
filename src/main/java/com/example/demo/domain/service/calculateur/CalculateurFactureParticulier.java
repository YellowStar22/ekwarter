package com.example.demo.domain.service.calculateur;

import com.example.demo.domain.bo.Consommation;
import com.example.demo.domain.bo.Contrat;

public class CalculateurFactureParticulier implements CalculateurFacture {
    private static final Contrat contrat = Contrat.PARTICULIER;
    @Override
    public double calculerFacture(Consommation consommation) {
        return consommation.getElectricity() * contrat.getElectricityPrice() + consommation.getGaz() * contrat.getGazPrice();
    }
}
