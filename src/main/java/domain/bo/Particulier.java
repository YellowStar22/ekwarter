package domain.bo;

public class Particulier extends Client{



    private Civilite civilite;

    private String nom;

    private String prenom;

    // Constructeur privé
    private Particulier(Builder builder) {
        super(builder.reference);
        this.civilite = builder.civilite;
        this.nom = builder.nom;
        this.prenom = builder.prenom;
    }


    public static class Builder {
        private String reference;
        private Civilite civilite;
        private String nom;
        private String prenom;

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder civilite(Civilite civilite) {
            this.civilite = civilite;
            return this;
        }

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public Particulier build() {
            return new Particulier(this);
        }
    }
}
