package domain.bo;

public class Consommation {

    int electricity;
    int gaz;

    public Consommation(int electricity, int gaz) {
        this.electricity = electricity;
        this.gaz = gaz;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getGaz() {
        return gaz;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }
}
