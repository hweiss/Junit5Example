package kt.java.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

     /*
     Range initialisieren:
        in Python:
            - range(10) -> Range von 0 (inklusive) bis 10 (exklusive), Schrittweite 1
            - range(3,10) -> Range von 3 (inklusive) bis 10 (exklusive), Schrittweite 1
            - range(2,15,2) -> Range von 2 (inklusive) bis 15 (exklusive), Schrittweite 2
     */
    @Test
    public void testRangeMitStartEndeUndRange() {
        Range r = Range.of(2,15,2);
        assertEquals("range(2,15,2)", r.toString());
    }

    @Test
    public void testRangeMitStartUndEnde() {
        Range r = Range.of(3,10);
        assertEquals(Range.of(3, 10, 1), r);
    }

    @Test
    public void testRangeNurMitEnde() {
        Range r = Range.of(10);
        assertEquals(Range.of(0, 10, 1), r);
    }

    @Test
    public void testRangeIstIterierbar() {
        Range r = Range.of(3);
        Iterator<Integer> it = r.iterator();
        assertTrue(it.hasNext());
        assertEquals(0, it.next());
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }
}
