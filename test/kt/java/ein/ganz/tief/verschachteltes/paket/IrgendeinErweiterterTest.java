package kt.java.ein.ganz.tief.verschachteltes.paket;

import org.junit.jupiter.api.Test;

public class IrgendeinErweiterterTest extends IrgendeinTest {

    // Diese Klasse erbt zusätzlich alle Methoden der Oberklasse inklusive
    // ihrer Annotationen.
    @Test
    public void erweiterterTest() {
        System.out.println("@Test 3");
    }

}
