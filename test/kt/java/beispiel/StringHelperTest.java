package kt.java.beispiel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelperTest {

    @Test
    public void testReverseString() {
        // Given
        // Gegeben ist ein String s mit dem Inhalt "abcde"
        String s = "abcde";
        // When
        // Wenn wir diesen String an die Funktion reverse übergeben...
        String r = StringHelper.reverse(s);
        // Then
        // Dann soll das Ergebnis "edcba" sein.
        assertEquals("edcba", r);
    }

}
