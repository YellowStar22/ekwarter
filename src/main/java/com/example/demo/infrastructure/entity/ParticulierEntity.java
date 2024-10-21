package com.example.demo.infrastructure.entity;

import com.example.demo.domain.bo.Civilite;

public class ParticulierEntity {

    private String reference;

    private Civilite civilite;

    private String nom;

    private String prenom;

    public ParticulierEntity(String reference, Civilite civilite, String nom, String prenom) {
        this.reference = reference;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
