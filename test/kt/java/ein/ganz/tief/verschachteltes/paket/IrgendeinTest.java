package kt.java.ein.ganz.tief.verschachteltes.paket;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IrgendeinTest {

    private static int statischeZahl = 0;

    private int zahl;

    @BeforeAll
    public static void prepare() {
        System.out.println("@BeforeAll");
        statischeZahl = 42;
    }

    public IrgendeinTest() {
        System.out.println("Konstruktor");
    }


    @BeforeEach
    public void prepareEach() {
        System.out.println("@BeforeEach");
        this.zahl = statischeZahl;
    }

    @Test
    public void testIrgendwas() {
        System.out.println("@Test 1");
        assertEquals(42, zahl);
    }

    @Test
    public void testIrgendwasAnderes() {
        System.out.println("@Test 2");
        zahl /= 2;
        assertEquals(21, zahl);
    }

    @AfterEach
    public void cleanupEach() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("@AfterAll");
        statischeZahl = 0;
    }
}
