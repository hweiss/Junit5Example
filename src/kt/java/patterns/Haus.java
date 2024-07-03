package kt.java.patterns;

import java.util.List;

/**
 * Das Builder-Pattern dient dazu, den Erstellungsprozess eines Objekts
 * greifbarer und schrittweise ausführbar zu gestalten.
 */
public class Haus {

    private String tuer;
    private List<String> etagen;
    private String garage;
    private String dach;
    private String waende;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Haus(String tuer, List<String> etagen, String garage, String dach, String waende) {
        this.tuer = tuer;
        this.etagen = etagen;
        this.garage = garage;
        this.dach = dach;
        this.waende = waende;
    }

    public static class Builder {
        private String tuer;
        private List<String> etagen;
        private String garage;
        private String dach;
        private String waende;

        public Builder mitTuer(String tuer) {
            this.tuer = tuer;
            return this;
        }

        public Builder mitEtagen(List<String> etagen) {
            this.etagen = etagen;
            return this;
        }

        public Builder mitWaenden(String waende) {
            this.waende = waende;
            return this;
        }
        public Builder mitGarage(String garage) {
            this.garage = garage;
            return this;
        }
        public Builder mitDach(String dach) {
            this.dach = dach;
            return this;
        }

        public Haus build() {
            return new Haus(tuer, etagen, garage, dach, waende);
        }
    }

    public static void main(String[] args) {
        // Dadurch, dass wir jeweils "this" zurückgeben,
        // können die Methoden hintereinander verketten
        Haus meinTraumHaus = Haus.newBuilder()
                .mitDach("Reet")
                .mitWaenden("Rote Ziegel")
                .mitEtagen(List.of("Keller", "Erdgeschoss", "Obergeschoss"))
                .build();

    }

}
