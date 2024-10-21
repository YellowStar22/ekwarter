package com.example.demo.infrastructure.entity;

public class ProfessionnelEntity {

    private String reference;

    private String siret;

    private String raisonSociale;

    private double chiffreAffaire;


    public ProfessionnelEntity() {
    }

    public ProfessionnelEntity(String reference, String siret, String raisonSociale, double chiffreAffaire) {
        this.reference = reference;
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.chiffreAffaire = chiffreAffaire;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
}
