package com.example.demo.domain.service.calculateur;

import com.example.demo.domain.bo.*;

public class CalculateurFactureProfessionnel implements CalculateurFacture {
    private final Contrat contrat;
    public CalculateurFactureProfessionnel(Client client) {
        this.contrat = ((Professionnel) client).isHautChiffreAffaire() ? Contrat.PROFESSIONNEL_PLUS : Contrat.PROFESSIONNEL_MOINS;
    }

    @Override
    public double calculerFacture(Consommation consommation) {
        return consommation.getElectricity() * contrat.getElectricityPrice() + consommation.getGaz() * contrat.getGazPrice();
    }
}