package kt.java.beispiel;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class StringHelperTest {

    @Test
    public void testReverseString() {
        String s = "abcde";
        String r = StringHelper.reverse(s);
        if ( r.equals("edcba")) {
            // alles super, test bestanden
        } else {
            throw new AssertionFailedError("Test nicht bestanden");
        }
    }

    @Test
    public void testStringStartsWith() {
        int i = 52;
        i /= 0;
    }

}
