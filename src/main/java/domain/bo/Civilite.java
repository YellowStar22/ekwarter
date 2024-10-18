package domain.bo;

public enum Civilite{
    MONSIEUR("Monsieur"),
    MADAME("Madame"),
    MADEMOISELLE("Mademoiselle");

    private final String label;

    private Civilite(String label) {
        this.label = label;
    }

}