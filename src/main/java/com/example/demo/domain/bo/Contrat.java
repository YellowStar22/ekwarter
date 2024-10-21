package com.example.demo.domain.bo;

public enum Contrat {
    PARTICULIER(0.121,0.115),
    PROFESSIONNEL_PLUS(0.114,0.111),
    PROFESSIONNEL_MOINS(0.118,0.113);

    private double electricityPrice;
    private double gazPrice;

    Contrat(double electricityPrice, double gazPrice) {
        this.electricityPrice = electricityPrice;
        this.gazPrice = gazPrice;
    }

    public double getGazPrice() {
        return gazPrice;
    }

    public double getElectricityPrice() {
        return electricityPrice;
    }

}
