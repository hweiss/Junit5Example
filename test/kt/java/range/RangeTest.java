package kt.java.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

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

    @Test
    public void testLeereRange() {
        Range r = Range.of(1, 1, 12);
        assertFalse(r.iterator().hasNext());
    }

    @ParameterizedTest
    @MethodSource("rangeValues")
    public void testCorrectValues(List<Integer> expected, Range actual) {
        assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> rangeValues() {
        return Stream.of(
                Arguments.of(List.of(2,4,6,8), Range.of(2, 9, 2)),
                Arguments.of(List.of(0,1,2,3,4,5,6,7,8,9), Range.of(10)),
                Arguments.of(List.of(5,6,7,8,9), Range.of(5,10)),
                Arguments.of(List.of(3,2,1), Range.of(3, 0, -1)),
                Arguments.of(List.of(), Range.of(4, 4)),
                Arguments.of(List.of(), Range.of(-1)),
                Arguments.of(List.of(), Range.of(4, 8, -1))
        );
    }

    @Test
    public void testUngueltigeErstellungWirdVerhindert() {
        assertThrows(IllegalArgumentException.class, () -> {
            Range r = Range.of(1, 2, 0);
        });
    }

    @Test
    public void testNoSuchElementExceptionWennAmEndeDerRange() {
        Iterator<Integer> it = Range.of(4).iterator();
        assertEquals(0, it.next());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertThrows(NoSuchElementException.class,
                it::next
        );
    }
}
