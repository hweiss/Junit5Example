package kt.java.range;

import java.util.Iterator;

/**
 * Ein Datentyp analog zu range() aus Python.
 */
public class Range implements Iterable<Integer> {

    /**
     * Erstellt eine Range mit Anfang 0 und Schrittweite 1.
     *
     * @param bis Letzter Wert (exklusive).
     * @return Die Range.
     */
    public static Range of(int bis) {
        return new Range(0, bis, 1);
    }

    /**
     * Erstellt eine Range mit Schrittweite 1.
     *
     * @param von Erster Wert (inklusive).
     * @param bis Letzter Wert (exklusive).
     * @return Die Range.
     */
    public static Range of(int von, int bis) {
        return new Range(von, bis, 1);
    }

    /**
     * Erstellt eine Range mit allen Angaben.
     * @param von Erster Wert (inklusive).
     * @param bis Letzter Wert (exklusive).
     * @param schritt Die Schrittweite.
     * @return Die Range.
     * @throws IllegalArgumentException Wenn 0 als Schrittweite angegeben wurde.
     */
    public static Range of(int von, int bis, int schritt) {
        return new Range(von, bis, schritt);
    }

    private final int von;
    private final int bis;
    private final int schritt;

    private Range(int von, int bis, int schritt) {
        if (schritt == 0) throw new IllegalArgumentException("Schrittweite darf nicht 0 sein");
        this.von = von;
        this.bis = bis;
        this.schritt = schritt;
    }

    // Generiert durch IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;
        return von == range.von && bis == range.bis && schritt == range.schritt;
    }

    // Generiert durch IntelliJ
    @Override
    public int hashCode() {
        int result = von;
        result = 31 * result + bis;
        result = 31 * result + schritt;
        return result;
    }

    @Override
    public String toString() {
        return String.format("range(%s,%s,%s)", von, bis, schritt);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {

        private int nextNum;

        public RangeIterator() {
            this.nextNum = von;
        }

        @Override
        public boolean hasNext() {
            if (schritt < 0) {
                // negative Schrittweite
                return nextNum > bis;
            } else {
                return nextNum < bis;
            }
        }

        @Override
        public Integer next() {
            int next = nextNum;
            nextNum += schritt;
            return next;
        }
    }



}
