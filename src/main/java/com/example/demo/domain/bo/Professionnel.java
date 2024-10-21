package com.example.demo.domain.bo;

public class Professionnel extends Client{

    private static final int RESSOURCES_SEUIL = 1000000;

    private String siret;

    private String raisonSociale;

    private double chiffreAffaire;

    public Professionnel() {
        super();
    }

    // Getters
    public String getSiret() {
        return siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public boolean isHautChiffreAffaire(){
        return Professionnel.RESSOURCES_SEUIL > chiffreAffaire ;
    }

    // Constructeur privé pour forcer l'utilisation du Builder
    public Professionnel(Builder builder) {
        super(builder.reference,true);
        this.siret = builder.siret;
        this.raisonSociale = builder.raisonSociale;
        this.chiffreAffaire = builder.chiffreAffaire;
    }

    // Classe Builder
    public static class Builder {
        private String reference;
        private String siret;
        private String raisonSociale;
        private double chiffreAffaire;


        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder siret(String siret) {
            this.siret = siret;
            return this;
        }

        public Builder raisonSociale(String raisonSociale) {
            this.raisonSociale = raisonSociale;
            return this;
        }

        public Builder chiffreAffaire(double chiffreAffaire) {
            this.chiffreAffaire = chiffreAffaire;
            return this;
        }

        public Professionnel build() {
            return new Professionnel(this);
        }
    }

}
