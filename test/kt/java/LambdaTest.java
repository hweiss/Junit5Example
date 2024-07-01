package kt.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class LambdaTest {

    public static void umfangreicheBerechnung() {
        for(long l = 0; l < 3L * Integer.MAX_VALUE; l++) {
            // passiert nix
        }
    }

    @Test
    public void testTimeout() {
        // "messende" Timeout-Überprüfung
        assertTimeout(
                Duration.ofSeconds(2),
                () -> {
                    for(long l = 0; l < 3L * Integer.MAX_VALUE; l++) {
                        // passiert nix
                    }
                }
        );
    }

    @Test
    public void testTimeoutPreemptively() {
        // abbrechende Timeout-Überprüfung
        assertTimeoutPreemptively(
                Duration.ofSeconds(2),
                LambdaTest::umfangreicheBerechnung
        );
    }

}
