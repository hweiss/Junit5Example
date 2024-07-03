package kt.java.patterns;

import java.util.List;

// Kompositum / Composite
// Zerlegung einer komplexen Datenstruktur in eine hierarchie von
// kleineren Datenstrukturen, die jeweils durch eigene Klassen
// umgesetzt werden
public class Kompositum {

    public static class Haus {

        private Keller keller;
        private List<Wohnung> wohnungen;
        private Dach dach;

    }

    public static class Keller {}

    public static class Wohnung {
    }

    public static class Dach {

    }
}
