package com.example.demo.infrastructure.entity;

public class ConsommationEntity {
    int electricite;
    int gaz;


    public ConsommationEntity() {
    }


    public ConsommationEntity(int electricite, int gaz) {
        this.electricite = electricite;
        this.gaz = gaz;
    }

    public int getElectricity() {
        return electricite;
    }

    public void setElectricity(int electricite) {
        this.electricite = electricite;
    }

    public int getGaz() {
        return gaz;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }
}
