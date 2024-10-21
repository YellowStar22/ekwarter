package com.example.demo.domain.bo;

public class Client {

    private String references;
    private boolean isProfessionel;

    public Client() {}

    public Client(String references,boolean isProfessionel) {
        this.isProfessionel = isProfessionel;
        this.references = references;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public boolean isProfessionel() {
        return isProfessionel;
    }
}
